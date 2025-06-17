const express = require('express');

const router = express.Router();

router.get('/',(req,res)=>{
    res.send('emp list');
});

router.get('/detail',(req,res)=>{
    const empno=req.query.empno;
    res.send(`emp (${empno}) detail`);
});


module.exports=router;