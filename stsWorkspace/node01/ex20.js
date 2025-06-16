const fs = require('fs');

//const msg = fs.readdirSync('./'); 현재 디렉토리 목록 like ls
// console.log(msg);

fs.writeFileSync('test02.txt', 'hello javascript',{flag:'a'});
const buf1 = fs.readFileSync('test02.txt');
console.log(buf1.toString());

// const buf1 = fs.readFileSync('ex01.js');
// console.log(buf1.toString());
