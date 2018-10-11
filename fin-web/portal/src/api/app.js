import axios from '@/libs/api.request';
export const gettextMenu = ({systemId}) => {
    const data = {
        systemId};
    return axios.request({
        url: 'meta/menu/selectMenuList',
        params: data,
        method: 'get'
    });
};
