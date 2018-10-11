import axios from '../../../libs/api.request';

export const apiOptionProductAll = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/selectProductAll',
        method: 'get'
    });
};

export const apiOptionAdditional = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMains/mainActiveList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiOptionBusiness = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMains/mainActiveList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiOptionCredit = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMains/mainActiveList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiOptionFinance = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMains/mainActiveList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiOptionMarketing = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMains/mainActiveList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
