import axios from '../../../libs/api.request';

export const apiActiveMainList = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMains/mainActiveList?pageNo=' + data.pageInfo.pageNo +
        '&pageSize=' + data.pageInfo.pageSize + '&activeCode=' + data.activeCode +
        '&activeName=' + data.activeName + '&activeStartTime=' + data.activeStartTime +
        '&activeEndTime=' + data.activeEndTime + '&areaName=' + data.areaName,
        method: 'get'
    });
};

export const apiActiveMainAdd = (data) => {
    return axios.request({
        url: '/mkmm/sales/actives',
        data,
        method: 'post'
    });
};

export const apiActiveMainView = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeAlls/queryActive?activeCode=' + data,
        method: 'get'
    });
};
