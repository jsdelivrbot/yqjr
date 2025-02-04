import axios from '../../../libs/api.request';
export const apiComwarningQueryList = (data) => {
    return axios.request({
        url: '/risk/stat/fctAltCustoms/selectFctAltCustomFenYe?pageNum=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const genJuZhiBiaoChaMingZiLuJing = (indicatorcode) => {
    return axios.request({
        url: '/risk/stat/indicators/selectByIndicatorcode?indicatorcode=' + indicatorcode,
        method: 'get'
    });
};
export const apiselectByIndicatorname = (indicatorname) => {
    return axios.request({
        url: '/risk/stat/indicators/selectByIndicatorname?indicatorname=' + indicatorname,
        method: 'get'
    });
};
export const chaXun = (data) => {
    return axios.request({
        url: '/risk/stat/fctAltCustoms/chaXunFctAltCustomFenYe',
        params: data,
        method: 'post'
    });
};

export const apiquerycomwarningByEventid = (eventid) => {
    return axios.request({
        url: '/risk/stat/fctAltCustoms/selectFctAltCustomByEventid?eventid=' + eventid,
        method: 'get'
    });
};
export const apiqueryIndicatorLogsByEventid = (eventid) => {
    return axios.request({
        url: '/risk/stat/indicatorLogss/selectByEventid?eventid=' + eventid,
        method: 'get'
    });
};
export const apicomwarningIndicatorLogss = (data) => {
    return axios.request({
        url: '/risk/stat/indicatorLogss/InsertIndicatorLogsRest',
        params: data,
        method: 'post'
    });
};
export const apiupdateIndicatorLogss = (data) => {
    return axios.request({
        url: '/risk/stat/indicatorLogss/patchById?id=' + data.id + '&asstest=' + data.xiangqing,
        method: 'get'
    });
};
