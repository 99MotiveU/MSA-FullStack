import React,{ useState } from "react";

function Ex01() {
  const [msg,setMsg]=useState('abc');
  
  return (
    <div>
        <h1>{msg}</h1>
        <button onClick={e=>setMsg('ABC')}>대문자</button>
        <button onClick={e=>setMsg('abc')}>소문자</button>
    </div>
  )
}

export default Ex01