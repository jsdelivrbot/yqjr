package com.yqjr.fin.fcsw.meta.api.dto;


public class DictItemDto  {

    private String name;
    private String value;
    private String simpleName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSimpleName() {return simpleName; }
	public void setSimpleName(String simpleName) {this.simpleName = simpleName; }
}