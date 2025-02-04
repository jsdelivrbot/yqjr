import axios from '../../../libs/api.request';

export const apiQueryPersonReviewList = (data) => {
    return axios.request({
        url: '/mkmm/sales/personMainReviews/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};

export const apiQueryPersonReviewViewById = (id) => {
    return axios.request({
        url: '/mkmm/sales/personMainReviews/reviewwatch?personTeamReviewId=' + id,
        method: 'get'
    });
};
export const apiQueryPersonReviewWorkFlowByPersonCode = (personCode) => {
    return axios.request({
        url: '/mkmm/sales/workFlows/selectWorkFlow?reviewId=' + personCode + '&pageNo=1&pageSize=100',
        method: 'get'
    });
};
export const apiUpdatePersonStatus = (personCode) => {
    return axios.request({
        url: '/mkmm/sales/personMainReviews/update?personCode=' + personCode,
        method: 'post'
    });
};
export const apiPersonReviewToSubmit = (data) => {
    return axios.request({
        url: '/mkmm/sales/personMainReviews/submit?personCode=' + data.personCode + '&workid=' + data.workid + '&opinion=' + data.opinion + '&reviewStatus=' + data.reviewStatus + '&personTeamReviewId=' + data.personTeamReviewId,
        data,
        method: 'post'
    });
};
