
package com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyzldynamicbillservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>createBill4FYZLDynamicBillServiceResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="createBill4FYZLDynamicBillServiceResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://service.fyzldynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/}message" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createBill4FYZLDynamicBillServiceResponse", propOrder = {
    "_return"
})
public class CreateBill4FYZLDynamicBillServiceResponse {

    @XmlElement(name = "return")
    protected Message _return;

    /**
     * ��ȡreturn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Message }
     *     
     */
    public Message getReturn() {
        return _return;
    }

    /**
     * ����return���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Message }
     *     
     */
    public void setReturn(Message value) {
        this._return = value;
    }

}
