import axios from '../../../libs/api.request';

export const apiOptionArea = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Zone?isUpCode=0',
        method: 'get'
    });
};

export const apiOptionProvince = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Province?isUpCode=0',
        method: 'get'
    });
};

export const apiOptionCity = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/City?isUpCode=1&upCode=' + data,
        method: 'get'
    });
};
