import axios from '@/libs/api.request';
// 项目查询 http://10.20.133.87:50001/mkmm/sales/projectBases/pageByJqGrid?pageNo=1&pageSize=10
export const apiQueryProjectList = (data) => {
    return axios.request({
        url: '/projectMaintenanceList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
// 项目新增 http://10.20.133.87:50001/mkmm/sales/projectBases/insert
export const apiAddProject = (data) => {
    return axios.request({
        url: '/addProject',
        data,
        method: 'post'
    });
};
// 项目删除 http://10.20.133.87:50001/mkmm/sales/projectBases/delete?id=2
export const apiDeleteProject = (id) => {
    return axios.request({
        url: '/deleteProject?id=' + id,
        method: 'get'
    });
};
