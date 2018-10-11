import axios from '../../../libs/api.request';
export const apiPersonPlanTrackList = (data) => {
    return axios.request({
        url: '/mkmm/sales/personSales/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiPersonPlanTrackSearchName = (code) => {
    return axios.request({
        url: '/mkmm/sales/personSales/qryPerson?personCode=' + code,
        method: 'get'
    });
};
export const apiCheckPersonCodeExist = (personCode) => {
    return axios.request({
        url: '/mkmm/sales/personMains/checkExsit?personCode=' + personCode,
        method: 'get'
    });
};
/**
 * 模糊查询
 * @param searchTeam
 * @returns {*}
 */
export const apiSearchName = (searchNmae) => {
    return axios.request({
        url: '/mkmm/sales/autoComplete/Person?name=' + searchNmae,
        method: 'get'
    });
};
