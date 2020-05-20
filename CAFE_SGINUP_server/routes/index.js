var express = require('express');
var router = express.Router();

router.use('/user', require('./user/index'));

router.use('/scheduler', require('./scheduler'));

module.exports = router;
