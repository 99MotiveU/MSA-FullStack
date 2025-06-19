import React, { useEffect, useRef, useState } from 'react'

function Ex09() {
    const [msg,setMsg]=useState("");
    let before=useRef('before');
  useEffect(()=>{
    before.current=msg;
  },[msg]);
  return (
    <>
        <input value={msg} onChange={e=>setMsg(e.target.value)}/>
        <div>msg:{msg}</div>
        <div>before:{before.current}</div>
    </>
  )
}

export default Ex09