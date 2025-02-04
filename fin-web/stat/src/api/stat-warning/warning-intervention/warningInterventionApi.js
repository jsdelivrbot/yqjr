import axios from '../../../libs/api.request';
export const apiInterventionQueryList = (data) => {
    return axios.request({
        url: '/risk/stat/fctAltCustoms/selectFctAltCustomFenYe?pageNum=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        method: 'get'
    });
};
export const apihandlestateQueryList = (data) => {
    return axios.request({
        url: '/risk/stat/fctAltCustoms/selectFctAltCustomByChandlestate?pageNum=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize + '&assvalue1=' + data.chandlestate + '&comcode=' + data.comcode,
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
export const apichaXunZhiBiao = (data) => {
    return axios.request({
        url: '/risk/stat/indicators/selIName',
        method: 'get'
    });
};
export const apichaXunQuHua = (data) => {
    return axios.request({
        url: '/meta/dictItem/getDictItem?code=Zone&flag=0',
        method: 'get'
    });
};
export const apiupdateHandlestate = (data) => {
    return axios.request({
        url: '/risk/stat/fctAltCustoms/updateHandlestateByEventid?eventid=' + data.eventid + '&handlestate=' + data.handlestate + '&modifiername=' + data.modifiername + '&modifier=' + data.modifier,
        method: 'get'
    });
};
