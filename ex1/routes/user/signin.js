var express = require('express');
var router = express.Router();

const util = require('../../module/utils');
const statusCode = require('../../module/statusCode');
const resMessage = require('../../module/responseMessage');
const db = require('../../module/pool');
const moment = require('moment');
require('moment-timezone');

moment.tz.setDefault("Asia/Seoul");


router.post('/', async (req, res) => {
  

  const signInQuery = 'INSERT INTO user (name, phone, birth, time) VALUES (?, ?, ?, ?)';
  const start_time = moment().format('YYYY-MM-DD HH:mm:ss');
  const signInResult = await db.queryParam_Parse(signInQuery, [req.body.name, req.body.phone, req.body.birth, start_time]);
  

    if (req.body.name==0 || req.body.phone==0|| req.body.birth ==0) {//입력값을 하나라도 입력받지 않으면 sginin fail
          res.status(200).send(util.successFalse(statusCode.DB_ERROR, resMessage.SIGNIN_FAIL));
    
      } 
    else {  
          res.status(200).send(util.successTrue(statusCode.OK, resMessage.SIGNIN_SUCCESS));
          console.log(req.body)

      }
    

});



module.exports = router;
