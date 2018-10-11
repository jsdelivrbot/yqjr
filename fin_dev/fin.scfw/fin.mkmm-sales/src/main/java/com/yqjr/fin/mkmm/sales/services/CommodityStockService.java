package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.entity.CommodityIn;
import com.yqjr.fin.mkmm.sales.entity.CommodityOut;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.CommodityStock;
import com.yqjr.fin.mkmm.sales.mapper.CommodityStockMapper;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Service
@Transactional(readOnly = true)
public class CommodityStockService extends BaseService<CommodityStockMapper, CommodityStock, Long> {

    @Autowired
    private CommodityStockMapper commodityStockMapper;
    /**
     * 物料入库
     */
    @Transactional
    public void inStock(CommodityIn commodityIn) {
        //获取入库信息
        String areaName = commodityIn.getAreaName();
        String commodityName = commodityIn.getCommodityName();
        String commodityTypeName = commodityIn.getCommodityTypeName();

        CommodityStock commodityStock = new CommodityStock();
        commodityStock.setAreaCode(commodityIn.getAreaCode());
        commodityStock.setCommodityTypeCode(commodityIn.getCommodityTypeCode());
        commodityStock.setCommodityCode(commodityIn.getCommodityCode());
        commodityStock.setCompany(commodityIn.getCompany());
        //获取当前库存
        CommodityStock stock = getStockNumber(commodityStock);
        Long stockNumber;
        if(StringUtils.isEmpty(stock)) {
            stockNumber = (long)0;
        } else {
            stockNumber = stock.getNowStock();
        }
        //计算当前库存
        stockNumber += commodityIn.getInNumber();

        if(!StringUtils.isEmpty(stock)) {
            //数据更新
            commodityStock.setId(stock.getId());
            commodityStock.setNowStock(stockNumber);
            this.patchById(commodityStock);
        } else {
            //数据新增
            commodityStock.setNowStock(stockNumber);
            commodityStock.setCommodityName(commodityName);
            commodityStock.setAreaName(areaName);
            commodityStock.setCommodityTypeName(commodityTypeName);
            this.insert(commodityStock);
        }

    }

    /**
     * 物料出库
     */
    @Transactional
    public void outStock(CommodityOut commodityOut) {
        //获取出库信息
        CommodityStock commodityStock = new CommodityStock();
        commodityStock.setAreaCode(commodityOut.getAreaCode());
        commodityStock.setCommodityTypeCode(commodityOut.getCommodityTypeCode());
        commodityStock.setCommodityCode(commodityOut.getCommodityCode());
        commodityStock.setCompany(commodityOut.getCompany());
        //获取当前库存
        CommodityStock stock = getStockNumber(commodityStock);
        Long stockNumber;
        if(StringUtils.isEmpty(stock)) {
            stockNumber = (long)0;
        } else {
            stockNumber = stock.getNowStock();
        }
        //计算当前库存
        stockNumber -= commodityOut.getPutNumber();
        if(stockNumber<0) {
            throw new ValidationException("库存不足，出库失败！");
        }
        //数据更新
        commodityStock.setId(stock.getId());
        commodityStock.setNowStock(stockNumber);
        this.patchById(commodityStock);

    }

    /**
     * 获取当前库存
     */
    public CommodityStock getStockNumber(CommodityStock commodityStock) {
        CommodityStock stock = commodityStockMapper.selectCommodityStock(commodityStock);

        return stock;
    }

}