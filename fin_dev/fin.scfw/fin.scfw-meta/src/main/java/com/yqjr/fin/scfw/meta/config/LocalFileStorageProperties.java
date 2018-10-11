package com.yqjr.fin.scfw.meta.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fileStorage.local")
public class LocalFileStorageProperties {
	
	private String dir;

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
	
	

}
