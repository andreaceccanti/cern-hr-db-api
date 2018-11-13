package it.infn.mw.cern.hr;

import java.time.Clock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties
public class CernHrDbServiceApplication {
  
  @Bean
  Clock defaultClock() {
    return Clock.systemDefaultZone();
  }
  
  public static void main(String[] args) {
    SpringApplication.run(CernHrDbServiceApplication.class, args);
  }
}
