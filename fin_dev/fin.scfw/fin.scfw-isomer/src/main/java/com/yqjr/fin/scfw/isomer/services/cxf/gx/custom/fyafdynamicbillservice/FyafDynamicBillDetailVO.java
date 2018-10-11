
package com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>fyafDynamicBillDetailVO complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="fyafDynamicBillDetailVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="detailId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dim01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dim04" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dimAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dimSubject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ITproject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="memo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="memo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="memo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="naturalCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fyafDynamicBillDetailVO", propOrder = {
    "detailId",
    "dim01",
    "dim04",
    "dimAccount",
    "dimSubject",
    "iTproject",
    "memo",
    "memo1",
    "memo2",
    "naturalCurrency"
})
public class FyafDynamicBillDetailVO {

    protected String detailId;
    protected String dim01;
    protected String dim04;
    protected String dimAccount;
    protected String dimSubject;
    @XmlElement(name = "ITproject")
    protected String iTproject;
    protected String memo;
    protected String memo1;
    protected String memo2;
    protected String naturalCurrency;

    /**
     * ��ȡdetailId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetailId() {
        return detailId;
    }

    /**
     * ����detailId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetailId(String value) {
        this.detailId = value;
    }

    /**
     * ��ȡdim01���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDim01() {
        return dim01;
    }

    /**
     * ����dim01���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDim01(String value) {
        this.dim01 = value;
    }

    /**
     * ��ȡdim04���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDim04() {
        return dim04;
    }

    /**
     * ����dim04���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDim04(String value) {
        this.dim04 = value;
    }

    /**
     * ��ȡdimAccount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimAccount() {
        return dimAccount;
    }

    /**
     * ����dimAccount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDimAccount(String value) {
        this.dimAccount = value;
    }

    /**
     * ��ȡdimSubject���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimSubject() {
        return dimSubject;
    }

    /**
     * ����dimSubject���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDimSubject(String value) {
        this.dimSubject = value;
    }

    /**
     * ��ȡiTproject���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITproject() {
        return iTproject;
    }

    /**
     * ����iTproject���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITproject(String value) {
        this.iTproject = value;
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
     * ��ȡnaturalCurrency���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaturalCurrency() {
        return naturalCurrency;
    }

    /**
     * ����naturalCurrency���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaturalCurrency(String value) {
        this.naturalCurrency = value;
    }

}
