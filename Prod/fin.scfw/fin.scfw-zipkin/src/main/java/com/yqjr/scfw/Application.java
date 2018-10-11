package com.yqjr.scfw;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import zipkin.server.EnableZipkinServer;

/**
 * User: Kyll
 * Date: 2017-11-27 11:29
 */
@EnableZipkinServer
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
