const fs = require('fs');

// rwx 일기/쓰기/실행
// a(append)
fs.open('test03.txt', 'a',(err,fd)=>{
    //결과가 3이 나오는 이유는 읽기,쓰기(1,2)
    console.log(err,fd);
});