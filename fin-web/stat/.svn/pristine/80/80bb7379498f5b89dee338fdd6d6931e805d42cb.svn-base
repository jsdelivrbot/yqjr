import axios from '../../../libs/api.request';
export const apiPersonMainQueryList = (data) => {
    return axios.request({
        url: '/mkmm/sales/personInTeGrates/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
// 查看详情tab页
export const apiQueryPersonMainById = (id) => {
    return axios.request({
        url: '/mkmm/sales/personInTeGrates/edit?id=' + id,
        method: 'get'
    });
};
// 人员定级历史信息
export const apiPersonGradingHistoryQueryList = (data) => {
    return axios.request({
        url: '/mkmm/sales/personInTeGrates/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
// 人员基本信息变更轨迹
export const apiPersonMainChangeTrackQueryList = (personCode) => {
    return axios.request({
        url: '/mkmm/sales/personInTeGrates/querypersonteamreview?personCode=' + personCode,
        method: 'get'
    });
};
// 人员基本信息变更轨迹结果
export const apiPersonMainChangeTrackQueryById = (id) => {
    return axios.request({
        url: '/mkmm/sales/personInTeGrates/personTeamHisQuery?id=' + id,
        method: 'get'
    });
};
// 重大事项
export const apiPersonMainQueryEvent = (data) => {
    return axios.request({
        url: '/mkmm/sales/eventPersons/pageByJqGridList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
// 重大事项结果
export const apiPersonMainQueryEventById = (id) => {
    return axios.request({
        url: '/mkmm/sales/eventPersons/selectById?id=' + id,
        method: 'get'
    });
};