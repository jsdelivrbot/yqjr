/* eslint-disable no-console,no-unused-vars */
import { getParams } from '@/libs/util';

export const login = req => {
    req = JSON.parse(req.body);
    console.log(req.userName + '-----');
    return {
        code: 200,
        data: {token: '123213123123131'},
        msg: ''
    };
};
