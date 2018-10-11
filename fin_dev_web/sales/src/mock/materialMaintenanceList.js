/* eslint-disable no-unused-vars */
import { getParams } from '@/libs/util';

export const materialMaintenanceList = req => {
    req = JSON.parse(req.body);
    return {
        code: 200,
        isSuccess: true,
        page: 1, // 当前页
        records: 20, // 总记录数
        total: 4, // 总页数
        rows: [{
            commodityName: '签字笔',
            commodityTypeName: '促销物料',
            remark: '11111111111111111111',
            id: '0000'
        }, {
            commodityName: '油卡充值卡',
            commodityTypeName: '品牌物料',
            remark: '22222222222222222222222',
            id: '0001'
        }, {
            commodityName: '笔记本',
            commodityTypeName: '广宣物料',
            remark: '33333333333333333333333',
            id: '0002'
        }]
    };
};
export const addMaterial = req => {
    req = JSON.parse(req.body);
    return {
        code: 200,
        isSuccess: true,
        msg: '添加成功!',
        page: 1, // 当前页
        records: 20, // 总记录数
        total: 4, // 总页数
        rows: [{
            name: '签字笔1',
            type: '促销物料',
            remark: '11111111111111111111'
        }]
    };
};
export const deleteMaterial = req => {
    req = JSON.parse(req.body);
    return {
        code: 200,
        isSuccess: true,
        msg: '删除成功!',
        page: 1, // 当前页
        records: 20, // 总记录数
        total: 4, // 总页数
        rows: [{
            name: '签字笔2',
            type: '促销物料',
            remark: '11111111111111111111'
        }]
    };
};