/* eslint-disable no-unused-vars */
import { getParams } from '@/libs/util';

export const demoList = req => {
    req = JSON.parse(req.body);
    return {
        code: 200,
        page: 1, // 当前页
        records: 20, // 总记录数
        total: 4, // 总页数
        rows: [{
            name: '张1',
            status: '2',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        },
        {
            name: '张2',
            status: '3',
            time: Math.floor(Math.random() * 7 + 1),
            update: new Date()
        }]
    };
};
