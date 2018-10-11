/* eslint-disable no-unused-vars */
import { getParams } from '@/libs/util';

export const projectMaintenanceList = req => {
    req = JSON.parse(req.body);
    return {
        code: 200,
        isSuccess: true,
        page: 1, // 当前页
        records: 20, // 总记录数
        total: 4, // 总页数
        rows: [{
            projectName: '一汽丰田贷款赠礼活动',
            remark: '11111111111111111111',
            id: '0000'
        }, {
            projectName: '一汽大众贷款赠礼活动',
            remark: '22222222222222222222222',
            id: '0001'
        }, {
            projectName: '一汽马自达这个活动',
            remark: '33333333333333333333333',
            id: '0002'
        }]
    };
};
export const addProject = req => {
    req = JSON.parse(req.body);
    return {
        code: 200,
        isSuccess: true,
        msg: '添加成功!',
        page: 1, // 当前页
        records: 20, // 总记录数
        total: 4, // 总页数
        rows: [{
            name: '一汽丰田1',
            remark: '11111111111111111111'
        }]
    };
};
export const deleteProject = req => {
    req = JSON.parse(req.body);
    return {
        code: 200,
        isSuccess: true,
        msg: '删除成功!',
        page: 1, // 当前页
        records: 20, // 总记录数
        total: 4, // 总页数
        rows: [{
            name: '一汽丰田2',
            remark: '11111111111111111111'
        }]
    };
};