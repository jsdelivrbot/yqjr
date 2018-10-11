import axios from '../../../libs/api.request';
export const ApiSearchArea = () => {
    return axios.request({
        url: '/mkmm/sales/planTracks/qryProvince',
        method: 'post'
    });
};
export const ApiSearchData = (data) => {
    return axios.request({
        url: '/mkmm/sales/planTracks/pageByTrackJqGrid',
        params: data,
        method: 'get'
    });
};
export const ApiSearchCarBrands = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandList?isUpCode=0',
        method: 'get'
    });
};
