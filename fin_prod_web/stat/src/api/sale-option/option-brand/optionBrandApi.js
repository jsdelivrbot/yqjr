import axios from '../../../libs/api.request';

export const apiOptionBrand = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandList?isUpCode=0',
        method: 'get'
    });
};

export const apiOptionSubBrand = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandDetail?isUpCode=1&upCode=' + data,
        method: 'get'
    });
};

export const apiOptionCarModel = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandName?upCode=' + data + '&isUpCode=1',
        method: 'get'
    });
};
