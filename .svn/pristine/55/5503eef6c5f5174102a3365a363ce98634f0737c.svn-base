import axios from '../../../libs/api.request';
export const apiQueryFeeDoPayList = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMatchMains/pageByJqGridQuery?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiQueryActiveDetailsByCode = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMatchDetails/pageByJqViewGrid?businessCode=' + data.businessCode + '&pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        method: 'get'
    });
};

export const apiFeeQueryActiveByCode = (data) => {
    return axios.request({
        url: '/mkmm/sales/feeMainReviews/feeMainReviewView?businessCode=' + data,
        method: 'get'
    });
};

export const apiFeeQueryProvinceList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Province?isUpCode=0',
        method: 'get'
    });
};

export const apiFeeQueryCityList = (provinces) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/City?isUpCode=' + 1 + '&upCode=' + provinces,
        method: 'get'
    });
};

export const apiFeeQueryAreaList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Zone?isUpCode=0',
        method: 'get'
    });
};

export const apiFeeQueryBrandsList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandList?isUpCode=0',
        method: 'get'
    });
};

export const apiFeeQuerySeriesList = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeCode=' + data + '&codeType=CarBrandDetail&isUpCode=1',
        method: 'get'
    });
};

export const apiFeeQueryModerList = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeCode=' + data + '&codeType=CarBrandName&isUpCode=1',
        method: 'get'
    });
};

export const apiFeeQueryAllProductList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/selectProductAll',
        method: 'get'
    });
};

export const apiFeeEditSubToRev = (data) => {
    return axios.request({
        url: '/mkmm/sales/feeMainReviews/feeMainReviewAdd?businessCode=' + data.activeMain.activeCode,
        data,
        method: 'patch'
    });
};
