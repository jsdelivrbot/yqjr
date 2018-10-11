import axios from '../../../libs/api.request';
export const apiTeamEventList = (data) => {
    return axios.request({
        url: '/mkmm/sales/eventTeams/pageByJqGridList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiQueryTeamEventById = (id) => {
    return axios.request({
        url: '/mkmm/sales/eventTeams/pageByJqGridList?id=' + id,
        method: 'get'
    });
};

export const apiTeamEventEditSubToRev = (data) => {
    return axios.request({
        url: '/mkmm/sales/eventTeams/' + data.id,
        data,
        method: 'patch'
    });
};

export const apiTeamEventAddSub = (data) => {
    return axios.request({
        url: '/mkmm/sales/eventTeams/add',
        data,
        method: 'post'
    });
};

export const apiDelTeamEventList = (data) => {
    return axios.request({
        url: '/mkmm/sales/eventTeams/batch/' + data.toString(),
        method: 'delete'
    });
};

export const apiQueryBySearchTeam = (data) => {
    return axios.request({
        url: '/mkmm/sales/autoComplete/Team?name=' + data,
        method: 'get'
    });
};
