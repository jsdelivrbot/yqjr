import axios from '../../../libs/api.request';
export const apiQueryPersonPlanList = (data) => {
    return axios.request({
        url: '/mkmm/sales/personPlans/pageByJqGrid?pageNo=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
