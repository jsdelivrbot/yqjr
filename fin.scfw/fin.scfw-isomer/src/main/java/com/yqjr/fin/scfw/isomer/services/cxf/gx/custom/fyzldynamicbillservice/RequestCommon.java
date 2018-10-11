
package com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyzldynamicbillservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>requestCommon complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="requestCommon"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="externalReferenceNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fromSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="msgRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requisitionUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requisitionUserCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requisitionUserDepartment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="toSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tradecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestCommon", propOrder = {
    "externalReferenceNo",
    "fromSystem",
    "msgRef",
    "requisitionUser",
    "requisitionUserCompany",
    "requisitionUserDepartment",
    "toSystem",
    "tradecode"
})
@XmlSeeAlso({
    FyzlDynamicBillMainVO.class
})
public class RequestCommon {

    protected String externalReferenceNo;
    protected String fromSystem;
    protected String msgRef;
    protected String requisitionUser;
    protected String requisitionUserCompany;
    protected String requisitionUserDepartment;
    protected String toSystem;
    protected String tradecode;

    /**
     * ��ȡexternalReferenceNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalReferenceNo() {
        return externalReferenceNo;
    }

    /**
     * ����externalReferenceNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalReferenceNo(String value) {
        this.externalReferenceNo = value;
    }

    /**
     * ��ȡfromSystem���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromSystem() {
        return fromSystem;
    }

    /**
     * ����fromSystem���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromSystem(String value) {
        this.fromSystem = value;
    }

    /**
     * ��ȡmsgRef���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgRef() {
        return msgRef;
    }

    /**
     * ����msgRef���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgRef(String value) {
        this.msgRef = value;
    }

    /**
     * ��ȡrequisitionUser���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequisitionUser() {
        return requisitionUser;
    }

    /**
     * ����requisitionUser���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequisitionUser(String value) {
        this.requisitionUser = value;
    }

    /**
     * ��ȡrequisitionUserCompany���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequisitionUserCompany() {
        return requisitionUserCompany;
    }

    /**
     * ����requisitionUserCompany���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequisitionUserCompany(String value) {
        this.requisitionUserCompany = value;
    }

    /**
     * ��ȡrequisitionUserDepartment���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequisitionUserDepartment() {
        return requisitionUserDepartment;
    }

    /**
     * ����requisitionUserDepartment���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequisitionUserDepartment(String value) {
        this.requisitionUserDepartment = value;
    }

    /**
     * ��ȡtoSystem���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToSystem() {
        return toSystem;
    }

    /**
     * ����toSystem���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToSystem(String value) {
        this.toSystem = value;
    }

    /**
     * ��ȡtradecode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradecode() {
        return tradecode;
    }

    /**
     * ����tradecode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradecode(String value) {
        this.tradecode = value;
    }

}
