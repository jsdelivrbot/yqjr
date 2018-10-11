import axios from '@/libs/api.request';
// 素材维护查询 http://10.20.133.87:50001/mkmm/sales/materialBases/pageByJqGrid?pageNo=1&pageSize=10
export const apiQueryMatterList = (data) => {
    return axios.request({
        url: '/matterMaintenanceList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
// 素材维护新增 http://10.20.133.87:50001/mkmm/sales/materialBases/insert
export const apiAddMatter = (data) => {
    return axios.request({
        url: '/addMatter',
        data,
        method: 'post'
    });
};
// 素材维护删除 http://10.20.133.87:50001/mkmm/sales/materialBases/delete
export const apiDeleteMatter = (id) => {
    return axios.request({
        url: '/deleteMatter?id=' + id,
        method: 'get'
    });
};