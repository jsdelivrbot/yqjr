import axios from '../../../libs/api.request';
export const apiTeamMainQueryList = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamMains/pageByJqGridAllList?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiQueryTeamMainById = (id) => {
    return axios.request({
        url: '/mkmm/sales/teamMains/pageByJqGrid?id=' + id,
        method: 'get'
    });
};

export const apiTeamMainQueryPerson = (teamCode) => {
    return axios.request({
        url: '/mkmm/sales/teamMains/queryPerson?teamCode=' + teamCode,
        method: 'get'
    });
};

export const apiTeamMainQueryHis = (teamCode) => {
    return axios.request({
        url: '/mkmm/sales/teamReviews/teamReviewQuery?teamCode=' + teamCode + '&reviewStatus=04',
        method: 'get'
    });
};

export const apiTeamMainQueryHisByid = (id) => {
    return axios.request({
        url: '/mkmm/sales/teamReviews/teamHisQuery?flowId=' + id,
        method: 'get'
    });
};

export const apiTeamMainQueryEvent = (teamCode) => {
    return axios.request({
        url: '/mkmm/sales/eventTeams/queryTeamEvent?teamCode=' + teamCode,
        method: 'get'
    });
};
export const apiTeamMainQueryEventById = (id) => {
    return axios.request({
        url: '/mkmm/sales/eventTeams/' + id,
        method: 'get'
    });
};
