package com.yqjr.fin.scfw.auth.infa.model;


public class Role {
    private Long id; //主键
    private Long systemId;//所属系统ID
    private String name; //角色名称
    private String roleType;//角色类型
    private String isSys;//是否系统数据
    private String useAble;//是否可用
    private Long creator;//创建人
    private String createTime;//创建时间
    private Long modifier;//最后更新人
    private String modifyTime;//最后更新时间
    private String remarks;//备注
    private String status;//有效无效标识
    private String enName; //角色英文名
    
    private String roleCode;
    
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSystemId() {
		return systemId;
	}
	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getIsSys() {
		return isSys;
	}
	public void setIsSys(String isSys) {
		this.isSys = isSys;
	}
	public String getUseAble() {
		return useAble;
	}
	public void setUseAble(String useAble) {
		this.useAble = useAble;
	}
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Long getModifier() {
		return modifier;
	}
	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
    
}

