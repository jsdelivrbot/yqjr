import axios from '../../libs/api.request';
export const apiUserList = (data) => {
    return axios.request({
        url: '/risk/stat/user/selectUser?pageNum=' + data.pageInfo.pageNo + '&pageSize=' + data.pageInfo.pageSize,
        params: data,
        method: 'get'
    });
};
export const apiDelUser = (data) => {
    return axios.request({
        url: '/risk/stat/user/delUser?params=' + data.toString(),
        method: 'get'
    });
};
