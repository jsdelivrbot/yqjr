import axios from '../../../libs/api.request';
export const apiUploadExcel = (data) => {
    return axios.request({
        url: '/mkmm/sales/personPlans/fileUpload',
        data,
        cache: false, // 上传文件无需缓存
        processData: false, // 用于对data参数进行序列化处理 这里必须false
        contentType: false,
        method: 'post'
    });
};
