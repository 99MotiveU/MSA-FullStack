import React, { useState } from 'react'

function Ex04(props){
    return (
    <div>
        <button onClick={e=>{
            // props.setMsg(props.msg.toUpperCase());
            props.setMsg((before)=>{
                return before.toUpperCase();
            });
        }}>변경</button>
    </div>
  )
}

function Ex03() {
  const [msg,setMsg]= useState('abc');
  return (
    <div>
        <h1>{msg}</h1>
        <Ex04 setMsg={setMsg} />
    </div>
  )
}

export default Ex03