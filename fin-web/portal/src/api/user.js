import axios from '@/libs/api.request';
export const login = ({ loginName, password }) => {
    const data = {
        loginName, password};
    return axios.request({
        url: 'meta/users/login',
        params: data,
        method: 'post'
    });
};
