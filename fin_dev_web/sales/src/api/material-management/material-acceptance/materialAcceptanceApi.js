import axios from '@/libs/api.request';
// 物料验收查询 http://10.20.133.87:50001/mkmm/sales/commodityAcceptances/pageByJqGrid?pageNo=1&pageSize=10
export const apiQueryMaterialAcceptanceList = (data) => {
    return axios.request({
        url: '/materialAcceptanceList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
// 物料验收登记 http://10.20.133.87:50001/mkmm/sales/commodityAcceptances/receive
export const apiRegisterMaterialAcceptance = (data) => {
    return axios.request({
        url: '/registerMaterialAcceptance',
        data,
        method: 'post'
    });
};
// 物料验收导出 http://10.20.133.87:50001/mkmm/sales/commodityAcceptances/export
export const apiExportMaterialAcceptance = (data) => {
    return axios.request({
        url: '/exportMaterialAcceptance',
        params: data,
        method: 'get'
    });
};