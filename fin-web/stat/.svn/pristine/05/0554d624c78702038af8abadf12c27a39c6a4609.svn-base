import axios from '../../../libs/api.request';

export const apiTeamPlanQueryBrandsList = () => {
    return axios.request({
        url: '/mkmm/sales/selectCode/CarBrandList?isUpCode=0',
        method: 'get'
    });
};

export const apiQueryTeamPlanTrackList = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamSales/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiQueryTeamPlanTrackName = (code) => {
    return axios.request({
        url: 'mkmm/sales/teamSales/qryTeam?teamCode=' + code,
        method: 'get'
    });
};
export const apiCheckTeamCodeExist = (code) => {
    return axios.request({
        url: 'mkmm/sales/teamMains/checkExsit?teamCode=' + code,
        method: 'get'
    });
};
/**
 * 模糊查询
 * @param searchTeam
 * @returns {*}
 */
export const apiSearchTeamName = (searchNmae) => {
    return axios.request({
        url: '/mkmm/sales/autoComplete/Team?name=' + searchNmae,
        method: 'get'
    });
};
