const fs=require('fs');

const stream=fs.createReadStream('test01.txt');
stream.on('data',function(data){
    console.log('여기까지');
});
stream.on('data',function(data){
    console.log(data.toString());
});