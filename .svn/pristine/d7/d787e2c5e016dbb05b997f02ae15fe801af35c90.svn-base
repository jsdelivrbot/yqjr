package com.yqjr.fin.fpms.product.dto;

import com.ritoinfo.framework.evo.sp.base.dto.PageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


@Data
public class ProductTreeDto implements Serializable {
	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 节点名称
	 */
	private String nodeName;

	/**
	 * 层级编号
	 */
	private Long levelNumber;

	/**
	 * 是否是最终节点
	 */
	private Long isFinalNode;

	/**
	 * 父节点id
	 */
	private Long parentId;

	/**
	 * 公司
	 */
	private Long company;

	/**
	 * 状态 0无效,1有效
	 */
	private Long flag;

}
