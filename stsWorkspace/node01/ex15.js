var path=require('path');
console.log(path.delimiter,path.sep);
console.log(__filename);
var p1="D:\\stsWorkspace\\..\\.\\stsWorkspace\\node01\\";
var f1="ex15.js";
console.log(p1+f1);
console.log(path.resolve(p1+f1));
console.log(path.parse(p1));
console.log('join',path.join(p1,'temp',f1));