package com.yqjr.fin.scfw.isomer.web;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;

import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Created by THINK on 2018/6/6.
 */
@Configuration
public class TestConfig {

   /* @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/test/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public TestInterService testService() {
        return new TestInterServiceImpl();
    }


    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), testService());
        endpoint.publish("/test");
        return endpoint;
    }*/

}
