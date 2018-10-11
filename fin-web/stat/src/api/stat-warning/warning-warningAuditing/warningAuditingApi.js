import axios from '../../../libs/api.request';
export const apiTeamMainQueryList = (data) => {
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
export const chaXun = (data) => {
    return axios.request({
        url: '/risk/stat/fctAltCustoms/chaXunFctAltCustomFenYe',
        params: data,
        method: 'post'
    });
};

export const apiTeamMainQueryPerson = (eventid) => {
    return axios.request({
        url: '/risk/stat/fctAltCustoms/selectFctAltCustomByEventid?eventid=' + eventid,
        method: 'get'
    });
};
export const apiIName = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/selIName',
        params: data,
        method: 'get'
    });
};
export const apiMany = (data) => {
    return axios.request({
        url: '/risk/stat/fctAltCustoms/selMany',
        params: data,
        method: 'post'
    });
};
export const apiquerycomwarningByEventid = (data) => {
    return axios.request({
        url: '/risk/stat/fctAltCustoms/selectFctAltCustomByEventid?eventid=' + data,
        method: 'get'
    });
};
export const apiExcel = (data) => {
    return axios.request({
        url: '/risk/stat/fctAltCustoms/fctAltCustomExport',
        params: data,
        method: 'get'
    });
};
