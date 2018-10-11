import axios from '../../../libs/api.request';

export const apiQueryPersonReviewProgressList = (data) => {
    return axios.request({
        url: '/mkmm/sales/personMainReviews/processPageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiSubPersonReviewProgressData = (data) => {
    return axios.request({
        url: '/mkmm/sales/personMainReviews/processmodifysubmit',
        data,
        method: 'post'
    });
};

export const apiValidatePersonReviewProNature = (data) => {
    return axios.request({
        url: '/mkmm/sales/personTeams/validatePersonNature?teamCode=' + data,
        method: 'get'
    });
};
