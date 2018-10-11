import axios from '../../../libs/api.request';
export const apiQueryPersonPlanList = (data) => {
    return axios.request({
        url: '/mkmm/sales/personPlans/pageByJqGrid?pageNo=' + '1' + '&pageSize=' + '10000',
        params: data,
        method: 'get'
    });
};
