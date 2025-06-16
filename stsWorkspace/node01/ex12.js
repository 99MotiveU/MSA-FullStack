// global 객체
console.log(global.parseInt("1234")+1);
console.log(parseInt("1234")+1);
console.log(Number("12.34")+1);
console.log(encodeURI('abcdefg'));
console.log(encodeURI('한글'));
console.log(decodeURI('%ED%95%9C%EA%B8%80'));
console.log(encodeURI('https://www.bing.com/search?q=한글&url=http://naver.com'));
// console.log(decodeURI('%ED%95%9C%EA%B8%80'));
console.log(encodeURIComponent('https://www.bing.com/search?q=한글&a=b'));
console.log(decodeURIComponent('https%3A%2F%2Fwww.bing.com%2Fsearch%3Fq%3D%ED%95%9C%EA%B8%80%26a%3Db'));