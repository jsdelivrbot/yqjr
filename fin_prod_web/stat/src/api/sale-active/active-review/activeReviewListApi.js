import axios from '../../../libs/api.request';

/**
 * 促销活动审核分页查询
 * @param data
 */
export const apiSearchDateList = (data) => {
    return axios.request({
        url: '/mkmm/sales/activeMainReviews/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiSearchActiveReviewDate = (data) => {
    return axios.request({
        url: '/mkmm/sales/actives/checkfind?id=' + data,
        method: 'get'
    });
};
export const apiActiveReviewProvinceList = (provinces) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Province?isUpCode=0',
        method: 'get'
    });
};
export const apiActiveReviewAreaList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/Zone?isUpCode=0',
        method: 'get'
    });
};
export const apiSearchCityByProvince = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/City?isUpCode=1&upCode=' + data,
        method: 'get'
    });
};
export const apiSearchBrandsList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandList?isUpCode=0',
        method: 'get'
    });
};
export const apiSearchSeriessList = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandDetail?isUpCode=1&upCode=' + data,
        method: 'get'
    });
};
export const apiSearchModerList = (data) => {
    return axios.request({
        url: '/mkmm/sales/selectCode/translateCode?codeCode=' + data + '&codeType=CarBrandName&isUpCode=1',
        method: 'get'
    });
};
export const apiActiveReviewAllProductList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/selectProductAll',
        method: 'get'
    });
};
export const apiSendReviewAction = (data) => {
    return axios.request({
        url: '/mkmm/sales/actives/checksubmit',
        dataType: 'json',
        data,
        cache: false, // 上传文件无需缓存
        processData: false, // 用于对data参数进行序列化处理 这里必须false
        contentType: false,
        method: 'POST'
    });
};
export const apiChangeStatus = (data) => {
    return axios.request({
        url: '/mkmm/sales/actives/checking?id=' + data.id + '&folowId=' + data.folowId,
        method: 'get'
    });
};
export const apiActiveReviewMessage = (data) => {
    return axios.request({
        url: '/mkmm/sales/workFlows/selectWorkFlow?reviewId=' + data + '&pageNo=1&pageSize=100&modType=03',
        method: 'get'
    });
};
