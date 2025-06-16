const arr1=['item1','item2','item3','item4'];
const arr2=[];
arr1.forEach(ele=>arr2.push(ele));
console.log(arr1,arr2);
arr1.push('item5');
console.log(arr1,arr2);
console.log('-------------------------------');
const arr3=['item0',...arr2,'item5'];
console.log(arr2,arr3);
console.log('-------------------------------');
for(idx in arr3)
    console.log(idx,arr3[idx]);
console.log('-------------------------------');
for(ele of arr3)
    console.log(ele);
console.log('-------------------------------');
let result=arr3.forEach((a,b,c)=>console.log(a,b,c));
console.log(result);
console.log('-------------------------------');
result=arr3.map((a,b,c)=>{console.log(a,b,c); return a.substring(3)});
console.log(result);
console.log('-------------------------------');
result=arr3.reduce((a,b,c)=>{console.log(a,b,c);return a+','+b;});
console.log(result);
console.log('-------------------------------');
result=arr3.filter((a,b,c)=>{console.log(a,b,c);return a!='item2';});
console.log(result);
console.log('-------------------------------');
result=arr3.every((a,b,c)=>{console.log(a,b,c);return true;});// and
console.log(result);
console.log('-------------------------------');
result=arr3.some((a,b,c)=>{console.log(a,b,c);return false;});// or
console.log(result);
console.log('-------------------------------');
// result=arr3.fill('test');// or
// console.log(result);
console.log('-------------------------------');
result=arr3.find((a,b,c)=>{console.log(a,b,c);return true;});// or
console.log(result);
console.log('-------------------------------');
result=arr3.findLast((a,b,c)=>{console.log(a,b,c);return true;});// or
console.log(result);







 