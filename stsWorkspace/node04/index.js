const express = require('express')
const bodyParser = require('body-parser')
const cookieParser = require('cookie-parser')
var cookieSession = require('cookie-session')
let ejs = require('ejs');
const app = express()
const port = 3000

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded())
// parse application/json
app.use(bodyParser.json())

//app.use(cookieParser())
app.use(cookieSession({
  name: 'session',
  keys: ['afsdlkfjasdlkfjdslakfdlaskfdsfjkldsfafljsdafsad'],

  // Cookie Options
  maxAge: 24 * 60 * 60 * 1000 // 24 hours
}))

app.set('view engine', 'ejs');

app.use('/',(req,res,cb)=>{
    console.log(req.url,req.session);
    cb();
});

app.use('/dept',require('./dept/dept.js'));
app.use('/emp',require('./emp/emp.js'));

app.get('/', (req, res) => {
//   res.send('수정!'+req.session.name)
  console.log("index");
  res.render('index');
})
app.get('/ex01', (req, res) => {
  console.log("param",req.query);
  req.session.name='scott';
  res.send('ex01 page!')
})
app.get('/ex02', (req, res) => {
  console.log("param",req.body);
//   req.session.destroy();
  res.clearCookie('session');
  console.log(req.session);
  res.send('ex02 page!')
})


app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})