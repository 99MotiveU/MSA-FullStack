function f1(){
    console.log('f1 = ');
    console.log(this);
}
const obj1 = {k1:f1, k2:'val2'};
// console.log(new f1());
var f2=()=>{
    console.log('f2 = ');
    console.log(this);
};
const obj2 = {k1:f2,k2:'val2'};
// console.log(new f2());
f1();
f2();
obj1.k1();
obj2.k1();
// 객체 메소드 표현 할 때에는 arrow fuction 사용 x, arrow function은 순수하게 function으로서의 기능만 수행 가능하다.


