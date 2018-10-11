import axios from '../../../libs/api.request';

export const apiQueryTeamReviewProList = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamReviews/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize + '&flag=1',
        params: data,
        method: 'get'
    });
};

export const apiQueryTeamReviewProViewById = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamReviews/' + data,
        method: 'get'
    });
};

export const apiQueryTeamReviewProWork = (data) => {
    return axios.request({
        url: '/mkmm/sales/workFlows/selectWorkFlow?reviewId=' + data + '&pageNo=1&pageSize=100&modType=' + '02',
        method: 'get'
    });
};

export const apiTeamReviewProToSubmit = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamReviews/queryEdit/' + data.id + '?type=' + data.reviewType,
        data,
        method: 'PATCH'
    });
};
