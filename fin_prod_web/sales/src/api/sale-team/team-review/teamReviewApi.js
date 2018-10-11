import axios from '../../../libs/api.request';

export const apiQueryTeamReviewList = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamReviews/pageByJqGridWork?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiQueryTeamReviewEditById = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamReviews/reviewing?id=' + data.id + '&workeid=' + data.workId,
        method: 'get'
    });
};

export const apiQueryTeamReviewViewById = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamReviews/teamReviewWatch?id=' + data.id + '&workeid=' + data.workId,
        method: 'get'
    });
};

export const apiQueryTeamReviewEditWork = (data) => {
    return axios.request({
        url: '/mkmm/sales/workFlows/selectWorkFlow?reviewId=' + data + '&pageNo=1&pageSize=100&&modType=' + '02',
        method: 'get'
    });
};

export const apiTeamReviewToSubmit = (data) => {
    return axios.request({
        url: '/mkmm/sales/teamReviews/submit?id=' + data.id + '&workeid=' + data.workId,
        data,
        method: 'patch'
    });
};
