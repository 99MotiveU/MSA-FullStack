const express = require('express');

const router = express.Router();

router.get('/',(req,res)=>{
    const arr=[];
    arr.push({deptno:1111,dname:'user1'});
    arr.push({deptno:2222,dname:'user2'});
    arr.push({deptno:3333,dname:'user3'});
    arr.push({deptno:4444,dname:'user4'});
    res.render('dept/list',{arr});
});
router.get('/:dept',(req,res)=>{
    const dept=req.params.dept;
    res.send(`detail(${dept}번) page`);
});

module.exports = router;