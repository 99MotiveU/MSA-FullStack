import React, { useEffect, useState } from 'react'

function Ex07() {
  const [msg, setMsg]=useState('abc');
  const [color, setColor]=useState('red');
  useEffect(()=>{
    console.log('init');
  },[]);  
  useEffect(()=>{
    console.log('msg가 변경되었습니다',msg);
  },[msg]);  
  useEffect(()=>{
    console.log('color가 변경되었습니다',color);
  },[color]);  
  return (
    <>
        <h1 style={{color}} >ex07-{msg}</h1>
        <button onClick={e=>{setMsg('ABC')}}>글자변경</button>
        <button onClick={e=>{setColor('blue')}}>색변경</button>
    </>
  )
}

export default Ex07