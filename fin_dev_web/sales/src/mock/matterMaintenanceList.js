/* eslint-disable no-unused-vars */
import { getParams } from '@/libs/util';

export const matterMaintenanceList = req => {
    req = JSON.parse(req.body);
    return {
        code: 200,
        isSuccess: true,
        page: 1, // 当前页
        records: 20, // 总记录数
        total: 4, // 总页数
        rows: [{
            materialCode: '00',
            materialName: '素材1',
            remark: '11111111111111111111',
            id: '0000'
        }, {
            materialCode: '01',
            materialName: '素材2',
            remark: '22222222222222222222222',
            id: '0001'
        }, {
            materialCode: '02',
            materialName: '素材3',
            remark: '33333333333333333333333',
            id: '0002'
        }]
    };
};
export const addMatter = req => {
    req = JSON.parse(req.body);
    return {
        code: 200,
        isSuccess: true,
        msg: '添加成功!',
        page: 1, // 当前页
        records: 20, // 总记录数
        total: 4, // 总页数
        rows: [{
            name: '素材1',
            type: '促销物料',
            remark: '11111111111111111111'
        }]
    };
};
export const deleteMatter = req => {
    req = JSON.parse(req.body);
    return {
        code: 200,
        isSuccess: true,
        msg: '删除成功!',
        page: 1, // 当前页
        records: 20, // 总记录数
        total: 4, // 总页数
        rows: [{
            name: '素材2',
            type: '促销物料',
            remark: '11111111111111111111'
        }]
    };
};