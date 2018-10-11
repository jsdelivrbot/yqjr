import axios from '@/libs/api.request';
// 物料维护查询 http://10.20.133.87:50001/mkmm/sales/ commodityBases/pageByJqGrid? pageNo=1& pageSize =10
export const apiQueryMaterialList = (data) => {
    return axios.request({
        url: '/materialMaintenanceList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
// 物料维护新增 http://10.20.133.87:50001/mkmm/sales/commodityBases/commodityAdd
export const apiAddMaterial = (data) => {
    return axios.request({
        url: '/addMaterial',
        data,
        method: 'post'
    });
};
// 物料维护删除 http://10.20.133.87:50001/mkmm/sales/commodityBases/commodityDel?id=2
export const apiDeleteMaterial = (id) => {
    return axios.request({
        url: '/deleteMaterial?id=' + id,
        method: 'get'
    });
};