import axios from '../../../libs/api.request';
export const apiQueryFeeReviewProgressList = (data) => {
    return axios.request({
        url: '/mkmm/sales/feeMainReviews/pageByQueryJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize + '&flag=1',
        params: data,
        method: 'get'
    });
};

export const apiQueryFeeReviewProByCode = (data) => {
    return axios.request({
        url: '/mkmm/sales/feeMainReviews/feeMainReviewView?businessCode=' + data,
        method: 'get'
    });
};

export const apiFeeReviewProProvinceList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Province?isUpCode=0',
        method: 'get'
    });
};

export const apiFeeReviewProCityList = (provinces) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/City?isUpCode=' + 1 + '&upCode=' + provinces,
        method: 'get'
    });
};

export const apiFeeReviewProAreaList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Zone?isUpCode=0',
        method: 'get'
    });
};

export const apiFeeReviewProBrandsList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandList?isUpCode=0',
        method: 'get'
    });
};

export const apiFeeReviewProSeriesList = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandDetail?isUpCode=1&upCode=' + data,
        method: 'get'
    });
};

export const apiFeeReviewProModerList = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeCode=' + data + '&codeType=CarBrandName&isUpCode=1',
        method: 'get'
    });
};

export const apiFeeReviewProAllProductList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/selectProductAll',
        method: 'get'
    });
};

export const apiQueryFeeReviewProViewWork = (data) => {
    return axios.request({
        url: '/mkmm/sales/workFlows/selectWorkFlow?reviewId=' + data + '&pageNo=1&pageSize=100&&modType=' + '04',
        method: 'get'
    });
};

export const apiFeeReviewProToSubmit = (data) => {
    // console.log(data)
    return axios.request({
        url: '/mkmm/sales/feeMainReviews/queryEdit?businessCode=' + data.activeMain.activeCode,
        data,
        method: 'PATCH'
    });
};
