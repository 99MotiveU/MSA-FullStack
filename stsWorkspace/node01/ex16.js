const url=require('url');
const msg='https://www.bing.com/search?q=%ED%95%9C%EA%B8%80&key2=val2';
console.log(url.parse(msg).pathname);
console.log(new url.URL(msg).searchParams.keys());
console.log(new url.URL(msg).searchParams.values());
console.log(new url.URL(msg).searchParams.entries());
console.log(new url,URL(msg).searchParams.get('q'));