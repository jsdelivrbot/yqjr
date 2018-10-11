import axios from '../../../libs/api.request';
export const apiTeamEventList = (data) => {
    return axios.request({
        url: '/risk/stat/indicatorRanges/selIndicatorRangesByPage?pageNum=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiw = (data) => {
    return axios.request({
        url: '/risk/stat/indicatorRanges/UpdateIndicatorRangesRest',
        data,
        method: 'post'
    });
};
export const apiQueryFive = () => {
    return axios.request({
        url: '/risk/stat/indicatorRanges/selMany',
        method: 'post'
    });
};
export const apiIndicatorTypes2 = (data) => {
    return axios.request({
        url: '/risk/stat/IndicatorTypesRest/SelectLikeByNameAndCode',
        params: data,
        method: 'get'
    });
};
export const apiQueryTeamEventById2 = (id) => {
    return axios.request({
        url: '/risk/stat/indicatorRanges/SelectIndicatorRangesById?id=' + id,
        method: 'get'
    });
};
export const apiQueryTeamEvent = (data) => {
    return axios.request({
        url: '/meta/dictItem/getDictItem?code=' + data.code + '&flag=' + data.flag,
        method: 'get'
    });
};
export const apiData = (data) => {
    return axios.request({
        url: '/meta/dictItem/getDictItem?code=' + data.code + '&flag=' + data.flag,
        method: 'get'
    });
};
export const apiQueryTeamEventById3 = (id) => {
    return axios.request({
        url: '/risk/stat/indicatorRanges/SelectIndicatorRangesById?id=' + id,
        method: 'get'
    });
};
export const apiQuery5 = (data) => {
    return axios.request({
        url: '/meta/dictItem/getDictItem?code=' + data.code + '&flag=' + data.flag,
        method: 'get'
    });
};
export const apiData9 = (data) => {
    return axios.request({
        url: '/meta/dictItem/getDictItem?code=' + data.code + '&flag=' + data.flag,
        method: 'get'
    });
};
export const apiAddM = (data) => {
    return axios.request({
        url: '/risk/stat/indicatorRanges/InsertIndicatorRangesRest',
        params: data,
        method: 'post'
    });
};
export const apiNames = (typecode) => {
    return axios.request({
        url: '/risk/stat/indicators/selIName?typecode=' + typecode,
        method: 'get'
    });
};
export const apiCode = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/selICode?id=' + data,
        method: 'get'
    });
};
export const apiDelTeamEventList = (data) => {
    return axios.request({
        url: '/risk/stat/indicatorRanges/DeleteIndicatorRangesRest?params=' + data.toString(),
        method: 'get'
    });
};
export const apiIT = (data) => {
    return axios.request({
        url: '/risk/stat/IndicatorTypesRest/selItypes',
        params: data,
        method: 'get'
    });
};
export const apiQueryBySearchTeam = (data) => {
    return axios.request({
        url: '/mkmm/sales/autoComplete/Team?name=' + data,
        method: 'get'
    });
};
export const apiIntId = (data) => {
    return axios.request({
        url: '/risk/stat/indicatorRanges/selIndId?indId=' + data.indId + '&signallamp=' + data.signallamp,
        method: 'get'
    });
};
export const apiSelByUp = (data) => {
    return axios.request({
        url: '/risk/stat/indicatorRanges/selByUp?indId=' + data.indId + '&id=' + data.id + '&signallamp=' + data.signallamp,
        method: 'get'
    });
};
