package com.yqjr.fin.fpms.product.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CountryDto implements Serializable {
	private Long id;
	private String code;
	private String name;
}
