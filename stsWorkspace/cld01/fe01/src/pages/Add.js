import React from 'react'
import { useNavigate } from 'react-router';

function Add() {
  let navigate = useNavigate();
  const addSubmit=e=>{
    e.preventDefault();
    const body={
      deptno:e.target.deptno.value,
      dname:e.target.dname.value,
      loc:e.target.loc.value
    };
    fetch('/api/dept/',{
      method:'POST',
      headers:{
        "Content-Type": "application/json",
      },
      body:JSON.stringify(body),
    }).then(e=>e.ok?navigate('/dept/'):null)
    .catch(console.log);
  };
  return (
    <>
      <h2>입력 페이지</h2>
      <form onSubmit={e=>addSubmit(e)}>
        <div>
          <label>deptno</label>
          <input name='deptno'/>
        </div>
        <div>
          <label>dname</label>
          <input name='dname'/>
        </div>
        <div>
          <label>location</label>
          <input name='loc'/>
        </div>
        <div>
          <button>입력</button>
        </div>
      </form>
    </>
  )
}

export default Add