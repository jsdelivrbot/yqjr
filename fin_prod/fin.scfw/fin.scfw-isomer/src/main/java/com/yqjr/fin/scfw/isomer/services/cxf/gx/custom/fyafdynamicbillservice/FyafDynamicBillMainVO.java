
package com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>fyafDynamicBillMainVO complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="fyafDynamicBillMainVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://service.fyafdynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/}requestCommon"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attachmentCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="businessCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="memo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="memo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="memo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="validCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fyafDynamicBillMainVO", propOrder = {
    "attachmentCount",
    "businessCode",
    "memo",
    "memo1",
    "memo2",
    "validCode"
})
public class FyafDynamicBillMainVO
    extends RequestCommon
{

    protected String attachmentCount;
    protected String businessCode;
    protected String memo;
    protected String memo1;
    protected String memo2;
    protected String validCode;

    /**
     * ��ȡattachmentCount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentCount() {
        return attachmentCount;
    }

    /**
     * ����attachmentCount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentCount(String value) {
        this.attachmentCount = value;
    }

    /**
     * ��ȡbusinessCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessCode() {
        return businessCode;
    }

    /**
     * ����businessCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessCode(String value) {
        this.businessCode = value;
    }

    /**
     * ��ȡmemo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemo() {
        return memo;
    }

    /**
     * ����memo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemo(String value) {
        this.memo = value;
    }

    /**
     * ��ȡmemo1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemo1() {
        return memo1;
    }

    /**
     * ����memo1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemo1(String value) {
        this.memo1 = value;
    }

    /**
     * ��ȡmemo2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemo2() {
        return memo2;
    }

    /**
     * ����memo2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemo2(String value) {
        this.memo2 = value;
    }

    /**
     * ��ȡvalidCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidCode() {
        return validCode;
    }

    /**
     * ����validCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidCode(String value) {
        this.validCode = value;
    }

}
