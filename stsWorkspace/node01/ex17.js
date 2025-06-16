const querystring=require('querystring');
let msg='https://www.bing.com/search?q=%ED%95%9C%EA%B8%80&key2=val2';
msg=msg.split('?')[1];
console.log(querystring.parse(msg));
console.log(querystring.parse(msg).q);
console.log(querystring.parse(msg).key2);
console.log(querystring.stringify({k1:'v1',k2:'v2'}));