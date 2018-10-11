import axios from '../../../libs/api.request';

export const apiQueryActiveReviewProList = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMainReviews/processlist?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiActiveReviewProBrandsList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandList?isUpCode=0',
        method: 'get'
    });
};

export const apiActiveReviewProAreaList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Zone?isUpCode=0',
        method: 'get'
    });
};

export const apiQueryActiveReviewProById = (data) => {
    return axios.request({
        url: '/mkmm/sales/actives/checkfind?id=' + data,
        method: 'get'
    });
};

export const apiQueryActiveReviewProEditById = (data) => {
    return axios.request({
        url: '/mkmm/sales/actives/modifyfind?activeId=' + data,
        method: 'get'
    });
};

export const apiActiveReviewProProvinceList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Province?isUpCode=0',
        method: 'get'
    });
};

export const apiActiveReviewProCityList = (provinces) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/City?isUpCode=' + 1 + '&upCode=' + provinces,
        method: 'get'
    });
};

export const apiActiveReviewProSeriesList = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeCode=' + data + '&codeType=CarBrandDetail&isUpCode=1',
        method: 'get'
    });
};

export const apiActiveReviewProModerList = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeCode=' + data + '&codeType=CarBrandName&isUpCode=1',
        method: 'get'
    });
};

export const apiActiveReviewProAllProductList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/selectProductAll',
        method: 'get'
    });
};

export const apiQueryActiveReviewProViewWork = (data) => {
    return axios.request({
        url: '/mkmm/sales/workFlows/selectWorkFlow?reviewId=' + data + '&modType=03' + '&pageNo=1&pageSize=100',
        method: 'get'
    });
};

export const apiActiveReviewToSubmit = (data) => {
    return axios.request({
        url: '/mkmm/sales/actives/change',
        data,
        method: 'post'
    });
};
