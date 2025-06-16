const express = require('express')
const app = express()
const port = 3000

// param
var bodyParser = require('body-parser');
app.use(bodyParser.json());	// json 등록
app.use(bodyParser.urlencoded({ extended : false }));	// URL-encoded 등록

app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.get('/intro.html',(req,res)=>{
    res.send('intro page');
});

app.get('/dept/list.html',(req,res)=>{
    console.log('get params:',req.query);
    res.json({k1:'val1',k2:'val2'});
});

app.post('/dept/list.html',(req,res)=>{
    console.log('post form',req.body);
    res.status(201).send();
});
app.get('/dept/:deptno',(req,res)=>{
    console.log('pathv',req.params);
    res.status(201).send();
});

app.put('/dept/',(req,res)=>{
    console.log(req.body);
    res.sendStatus(200);
});
app.delete('/dept/:deptno',(req,res)=>{
    console.log('pathv',req.params);
    res.status(200).send();
});

app.get('/emp/',(req,res)=>{
    res.redirect('/');
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})