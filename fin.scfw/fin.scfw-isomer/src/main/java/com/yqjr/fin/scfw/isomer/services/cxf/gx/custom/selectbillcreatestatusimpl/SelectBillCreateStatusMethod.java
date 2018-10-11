
package com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>selectBillCreateStatusMethod complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="selectBillCreateStatusMethod"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="requestCommon" type="{http://service.selectbillcreatestatusimpl.server.expense.yqjr.webservice.cc.epoch.com/}requestCommon" minOccurs="0"/&gt;
 *         &lt;element name="billStatusList" type="{http://service.selectbillcreatestatusimpl.server.expense.yqjr.webservice.cc.epoch.com/}billStatusVO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "selectBillCreateStatusMethod", propOrder = {
    "requestCommon",
    "billStatusList"
})
public class SelectBillCreateStatusMethod {

    protected RequestCommon requestCommon;
    protected List<BillStatusVO> billStatusList;

    /**
     * ��ȡrequestCommon���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RequestCommon }
     *     
     */
    public RequestCommon getRequestCommon() {
        return requestCommon;
    }

    /**
     * ����requestCommon���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RequestCommon }
     *     
     */
    public void setRequestCommon(RequestCommon value) {
        this.requestCommon = value;
    }

    /**
     * Gets the value of the billStatusList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billStatusList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillStatusList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillStatusVO }
     * 
     * 
     */
    public List<BillStatusVO> getBillStatusList() {
        if (billStatusList == null) {
            billStatusList = new ArrayList<BillStatusVO>();
        }
        return this.billStatusList;
    }

}
