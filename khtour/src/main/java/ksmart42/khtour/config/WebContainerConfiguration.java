package ksmart42.khtour.config;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class WebContainerConfiguration {
  @Bean
  public ServletContextInitializer servletContextInitializer() {
    return servletContext -> servletContext.setSessionTrackingModes(Collections.emptySet());
  }
}
