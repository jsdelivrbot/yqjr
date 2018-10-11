package com.yqjr.fin.scfw.meta.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fileStorage.fastdfs")
public class FastDFSFileStorageProperties {
	private String connect_timeout_in_seconds ;
	private String network_timeout_in_seconds ;
	private String charset ;
	private String http_anti_steal_token ;
	private String http_secret_key ;
	private String http_tracker_http_port  ;
	private String tracker_servers  ;
	public String getConnect_timeout_in_seconds() {
		return connect_timeout_in_seconds;
	}
	public void setConnect_timeout_in_seconds(String connect_timeout_in_seconds) {
		this.connect_timeout_in_seconds = connect_timeout_in_seconds;
	}
	public String getNetwork_timeout_in_seconds() {
		return network_timeout_in_seconds;
	}
	public void setNetwork_timeout_in_seconds(String network_timeout_in_seconds) {
		this.network_timeout_in_seconds = network_timeout_in_seconds;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String getHttp_anti_steal_token() {
		return http_anti_steal_token;
	}
	public void setHttp_anti_steal_token(String http_anti_steal_token) {
		this.http_anti_steal_token = http_anti_steal_token;
	}
	public String getHttp_secret_key() {
		return http_secret_key;
	}
	public void setHttp_secret_key(String http_secret_key) {
		this.http_secret_key = http_secret_key;
	}
	public String getHttp_tracker_http_port() {
		return http_tracker_http_port;
	}
	public void setHttp_tracker_http_port(String http_tracker_http_port) {
		this.http_tracker_http_port = http_tracker_http_port;
	}
	public String getTracker_servers() {
		return tracker_servers;
	}
	public void setTracker_servers(String tracker_servers) {
		this.tracker_servers = tracker_servers;
	}
	
}
