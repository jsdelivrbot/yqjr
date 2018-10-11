import axios from '@/libs/api.request';
export const apiDemoList = (data, pageNum, pageSize) => {
    return axios.request({
        url: 'demoList?pageNum=' + pageNum + '&pageSize' + pageSize,
        data,
        method: 'post'
    });
};
