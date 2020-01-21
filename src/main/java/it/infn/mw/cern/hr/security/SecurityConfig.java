/**
 * Copyright (c) Istituto Nazionale di Fisica Nucleare (INFN). 2016-2020
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.infn.mw.cern.hr.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.boot.actuate.metrics.export.prometheus.PrometheusScrapeEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.infn.mw.cern.hr.api.Role;
import it.infn.mw.cern.hr.config.ServiceConfigurationProperties;

@Configuration
public class SecurityConfig {

  public static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);

  @Configuration
  @Order(1001)
  @Profile("dev")
  public static class H2ConsoleSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      HttpSecurity h2Console = http.requestMatchers()
        .antMatchers("/h2-console", "/h2-console/**")
        .and()
        .csrf()
        .disable();

      h2Console.httpBasic();
      h2Console.headers().frameOptions().disable();

      h2Console.authorizeRequests().antMatchers("/h2-console/**", "/h2-console").permitAll();
    }
  }


  @Configuration
  @EnableWebSecurity
  @Order(1000)
  public static class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ObjectMapper mapper;

    public AccessDeniedHandler accessDeniedHandler() {
      return new ApiAccessDeniedHandler(mapper);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager udm(ServiceConfigurationProperties config,
        PasswordEncoder encoder) {

      UserDetails apiUser = User.withUsername(config.getApiUser().getUsername())
        .password(encoder.encode(config.getApiUser().getPassword()))
        .roles(Role.API.name())
        .build();

      UserDetails metricsUser = User.withUsername(config.getMetricsUser().getUsername())
        .password(encoder.encode(config.getMetricsUser().getPassword()))
        .roles(Role.METRICS.name())
        .build();

      return new InMemoryUserDetailsManager(apiUser, metricsUser);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .requestMatchers(EndpointRequest.to(HealthEndpoint.class, InfoEndpoint.class))
        .permitAll()
        .requestMatchers(EndpointRequest.to(MetricsEndpoint.class, PrometheusScrapeEndpoint.class))
        .hasRole(Role.METRICS.name())
        .mvcMatchers("/api/**")
        .hasRole(Role.API.name())
        .and()
        .httpBasic()
        .and()
        .exceptionHandling()
        .accessDeniedHandler(accessDeniedHandler())
        .and().csrf().disable();
    }
  }
}
