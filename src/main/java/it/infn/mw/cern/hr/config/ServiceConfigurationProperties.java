package it.infn.mw.cern.hr.config;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("service")
public class ServiceConfigurationProperties{
  
  public static class User {
    
    @NotBlank(message="username cannot be a blank string")
    String username;
    
    @NotBlank(message="password cannot be a blank string")
    String password;
    
    public String getUsername() {
      return username;
    }
    public void setUsername(String username) {
      this.username = username;
    }
    public String getPassword() {
      return password;
    }
    public void setPassword(String password) {
      this.password = password;
    }
  }
  
  private User apiUser;
  
  @Valid
  private User metricsUser;
  
 
  public User getApiUser() {
    return apiUser;
  }

  public void setApiUser(User apiUser) {
    this.apiUser = apiUser;
  }

  public User getMetricsUser() {
    return metricsUser;
  }

  public void setMetricsUser(User metricsUser) {
    this.metricsUser = metricsUser;
  }
}
