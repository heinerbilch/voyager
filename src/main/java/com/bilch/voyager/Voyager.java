package com.bilch.voyager;

import org.apache.catalina.Valve;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.RemoteIpValve;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Voyager {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Voyager.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addAdditionalTomcatConnectors(createConnector());
        tomcat.addContextValves(createRemoteIpValves());
        return tomcat;
    }

	private Valve createRemoteIpValves() {
	    RemoteIpValve remoteIpValve = new RemoteIpValve();
	    remoteIpValve.setRemoteIpHeader("x-forwarded-for");
	    remoteIpValve.setProtocolHeader("x-forwarded-proto");
	    return remoteIpValve;
	}

	private Connector createConnector() {
		Connector connector = new Connector("AJP/1.3");
//		String protocol = "AJP/1.3";
//		connector.setProtocol(protocol);
		connector.setPort(8009);
		return connector;
	}

}
