import axios from '../../../libs/api.request';
export const apiTeamList = (data) => {
    return axios.request({
        url: '/risk/stat/IndicatorTypesRest/SelectLikeByNameAndCode?pageNum=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiQueryWarningById = (id) => {
    return axios.request({
        url: '/risk/stat/IndicatorTypesRest/SelectIndicatorTypesRestById?id=' + id,
        method: 'get'
    });
};

export const apiUpdate = (data) => {
    return axios.request({
        url: '/risk/stat/IndicatorTypesRest/UpdateIndicatorTypesRest?code=' + data.code + '&name=' + data.name + '&remark=' + data.remark + '&id=' + data.id,
        data,
        method: 'get'
    });
};
export const apiwarningAdd = (data) => {
    return axios.request({
        url: '/risk/stat/IndicatorTypesRest/InsertIndicatorTypesRest?code=' + data.code + '&name=' + data.name + '&remark=' + data.remark,
        data,
        method: 'get'
    });
};
export const apiyanZhengCode = (code) => {
    return axios.request({
        url: '/risk/stat/IndicatorTypesRest/SelectByName?code=' + code,
        method: 'get'
    });
};
export const apiwarningDelete = (data) => {
    return axios.request({
        url: '/risk/stat/IndicatorTypesRest/SelectTypecodByCode?idteam=' + data.toString(),
        data,
        method: 'get'
    });
};
