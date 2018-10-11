
package com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>createBill4FYAFDynamicBillService complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="createBill4FYAFDynamicBillService"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mainVO" type="{http://service.fyafdynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/}fyafDynamicBillMainVO" minOccurs="0"/&gt;
 *         &lt;element name="detailVOList" type="{http://service.fyafdynamicbillservice.server.charge.yqjr.webservice.cc.epoch.com/}fyafDynamicBillDetailVO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createBill4FYAFDynamicBillService", propOrder = {
    "mainVO",
    "detailVOList"
})
public class CreateBill4FYAFDynamicBillService {

    protected FyafDynamicBillMainVO mainVO;
    protected List<FyafDynamicBillDetailVO> detailVOList;

    /**
     * ��ȡmainVO���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FyafDynamicBillMainVO }
     *     
     */
    public FyafDynamicBillMainVO getMainVO() {
        return mainVO;
    }

    /**
     * ����mainVO���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FyafDynamicBillMainVO }
     *     
     */
    public void setMainVO(FyafDynamicBillMainVO value) {
        this.mainVO = value;
    }

    /**
     * Gets the value of the detailVOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detailVOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetailVOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FyafDynamicBillDetailVO }
     * 
     * 
     */
    public List<FyafDynamicBillDetailVO> getDetailVOList() {
        if (detailVOList == null) {
            detailVOList = new ArrayList<FyafDynamicBillDetailVO>();
        }
        return this.detailVOList;
    }

}
