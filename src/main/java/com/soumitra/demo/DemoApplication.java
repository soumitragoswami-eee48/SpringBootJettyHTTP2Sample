package com.soumitra.demo;

import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

// the following works with springboot 2.2+ with default tomcat v9 shipped with it
// alternatively we can also set server.protocol server.http2.enabled=true in application properties
// BUT - it needs Jdk 9 to work out of the box - hence the need of using the Jetty server
//@Bean
//public ConfigurableServletWebServerFactory tomcatCustomizer() {
//    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//    factory.addConnectorCustomizers(connector -> connector.addUpgradeProtocol(new Http2Protocol()));
//    return factory;
//}
    
    
    
    
    // config jetty server
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setPort(9000);
        factory.setContextPath("/app");
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
        return factory;
    }


}
