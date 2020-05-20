var express = require('express');
var router = express.Router();
const util = require('../module/utils');
const statusCode = require('../module/statusCode');
const resMessage = require('../module/responseMessage');
const db = require('../module/pool');
const moment = require('moment');
const cron = require('node-cron');

cron.schedule('0 0 0 * * *', async() => {//자정에 user테이블의 데이터 전부 삭제
    const updateUserQuery = 'DELETE FROM user';
    const updateUserResult = await db.queryParam_None(updateUserQuery);
    console.log(updateUserResult);
})


module.exports = router;