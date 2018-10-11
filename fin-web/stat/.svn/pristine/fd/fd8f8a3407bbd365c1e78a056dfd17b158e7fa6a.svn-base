import axios from '../../../libs/api.request';
export const apiQueryFeeReviewList = (data) => {
    return axios.request({
        url: '/mkmm/sales/feeMainReviews/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiQueryFeeReviewByCode = (data) => {
    return axios.request({
        url: '/mkmm/sales/feeMainReviews/feeMainReviewView?businessCode=' + data,
        method: 'get'
    });
};

export const apiUpdateReviewStatus = (data) => {
    return axios.request({
        url: '/mkmm/sales/feeMainReviews/feeMainReviewQureyView?businessCode=' + data,
        method: 'get'
    });
};

export const apiFeeReviewProvinceList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Province?isUpCode=0',
        method: 'get'
    });
};

export const apiFeeReviewCityList = (provinces) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/City?isUpCode=' + 1 + '&upCode=' + provinces,
        method: 'get'
    });
};

export const apiFeeReviewAreaList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Zone?isUpCode=0',
        method: 'get'
    });
};

export const apiFeeReviewBrandsList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandList?isUpCode=0',
        method: 'get'
    });
};

export const apiFeeReviewSeriesList = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeCode=' + data + '&codeType=CarBrandDetail&isUpCode=1',
        method: 'get'
    });
};

export const apiFeeReviewModerList = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeCode=' + data + '&codeType=CarBrandName&isUpCode=1',
        method: 'get'
    });
};

export const apiFeeReviewAllProductList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/selectProductAll',
        method: 'get'
    });
};

export const apiQueryFeeReviewViewWork = (data) => {
    return axios.request({
        url: '/mkmm/sales/workFlows/selectWorkFlow?reviewId=' + data + '&pageNo=1&pageSize=100&&modType=' + '04',
        method: 'get'
    });
};

export const apiFeeReviewToSubmit = (data) => {
    return axios.request({
        url: '/mkmm/sales/feeMainReviews/feeMainReviewAduitAdd?businessCode=' + data.activeMain.activeCode,
        data,
        method: 'PATCH'
    });
};
