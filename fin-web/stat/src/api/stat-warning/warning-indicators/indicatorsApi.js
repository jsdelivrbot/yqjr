import axios from '../../../libs/api.request';
// var qs = require('qs');
export const apiTeamList = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/selIndicatorsBypage?pageNum=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiIndicatorTypes = (data) => {
    return axios.request({
        url: '/risk/stat/IndicatorTypesRest/SelectLikeByNameAndCode?pageNum=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiDelTeamList = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/DeleteIndicatorsRest?params=' + data.toString(),
        method: 'get'
    });
};
export const apiTeamAddToReview = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/InsertIndicatorsRest',
        params: data,
        method: 'post'
    });
};
export const apiQueryTeamById = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/SelectIndicatorsById?id=' + data,
        method: 'get'
    });
};
export const apiSubmitToReview = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/UpdateIndicatorsRest',
        data,
        method: 'post'
    });
};
export const apiITy = (data) => {
    return axios.request({
        url: '/risk/stat/IndicatorTypesRest/selItypes',
        params: data,
        method: 'get'
    });
};
export const apiSelIndicator = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/selMycode?indicatorcode=' + data,
        method: 'get'
    });
};
export const apiIndLevel = () => {
    return axios.request({
        url: '/risk/stat/indicators/selIndlevel',
        method: 'post'
    });
};
export const apiCom = (data) => {
    return axios.request({
        url: '/meta/dictItem/getDictItem?code=' + data.code + '&flag=' + data.flag,
        method: 'get'
    });
};
export const apiCom2 = (data) => {
    return axios.request({
        url: '/meta/dictItem/getDictItem?code=' + data.code + '&flag=' + data.flag,
        method: 'get'
    });
};
export const apiSelByUpd = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/selByUpd?indicatorcode=' + data.indicatorcode + '&id=' + data.id,
        method: 'get'
    });
};
