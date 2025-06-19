import React, { useRef, useState } from 'react'

function Ex88({la,ref}){
    const [msg, setMsg]=useState('');
    return (
        <div>
                <label>{la}</label>
                <input name='ip1' ref={ref} value={msg}
                onChange={e=>setMsg(e.target.value)}
                />
        </div>
    );
}

function Ex08() {
  const ip1=useRef();
  const ip2=useRef();
  const ip3=useRef();
  const cb1=e=>{
    e.preventDefault();
    // console.log('전송취소');
    // console.log(e.target.ip1.value,e.target.ip2.value,e.target.ip3.value);
    // console.log(window.document.querySelector('input').value);
    console.log(ip1.current.value,ip2.current.value,ip3.current.value);
  };  
  
  return (
    <>
        <h1>접근</h1>
        <form onSubmit={cb1}>
            <Ex88 la="input1" ref={ip1}/>
            <Ex88 la="input2" ref={ip2}/>
            <Ex88 la="input3" ref={ip3}/>
            <div>
                <button>전송</button>
            </div>
        </form>
    </>
  )
}

export default Ex08