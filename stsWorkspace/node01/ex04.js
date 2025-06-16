import { json } from "stream/consumers";

const obj1 = { k1: "v1" };
const obj2 = { k1: "v1" };

var k1 = "a1";
const obj3 = { k1: "v1" }; // "k1":"v1"
obj3[k1] = "v2"; // "a1":"v2"

console.log(JSON.stringify(obj3));
const obj4 = { k1 };
const obj5 = { k1: k1 };
console.log(JSON.stringify(obj4));
console.log(JSON.stringify(obj5));
