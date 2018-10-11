import axios from '../../../libs/api.request';
export const apiTeamList = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamMains/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiQueryTeamById = (id) => {
    return axios.request({
        url: '/mkmm/sales/teamMains/pageByJqGrid?id=' + id,
        method: 'get'
    });
};

export const apiSubmitToReview = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamReviews/edit/' + data.id,
        data,
        method: 'patch'
    });
};
export const apiTeamAddToReview = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamReviews/add',
        data,
        method: 'post'
    });
};
export const apiValidateTeamName = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamMains/checkTeamName?teamName=' + data,
        method: 'get'
    });
};
