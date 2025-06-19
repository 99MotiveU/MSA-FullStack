import React, { useRef } from 'react'
import { useNavigate } from 'react-router';

function Add() {
  const navigate=useNavigate();
  const i1=useRef();
  const i2=useRef();
  const i3=useRef();
  const div={marginTop:'10px'};
  const btn={marginTop:'5px'};
  const submitCB=e=>{
    e.preventDefault();
    const deptno=i1.current.value;
    const dname=i2.current.value;
    const loc=i3.current.value;
    fetch('/api/',{
        method: "POST",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body:`deptno=${deptno}&dname=${dname}&loc=${loc}`
    })
        .then(e=>e.json())
        .then(e=>{
            navigate('/dept/');
        })
        .catch(window.alert);
  };
  const backCB=e=>{
    navigate(-1);
  };
  return (
    <>
    <form onSubmit={submitCB} style={{marginTop:'20px'}}> 
        <h1 class="h3 mb-3 fw-normal">입력 페이지</h1> 
        <div style={div} class="form-floating"> 
            <input type="text" ref={i1} class="form-control" name="deptno" placeholder="deptno"/> 
            <label>deptno</label> 
        </div> 
        <div style={div} class="form-floating"> 
            <input type="text" ref={i2} class="form-control" name="dname" placeholder="dname"/> 
            <label>dname</label> 
        </div> 
        <div style={div} class="form-floating"> 
            <input type="text" ref={i3} class="form-control" name="loc" placeholder="location"/> 
            <label>location</label> 
        </div> 
        <button style={btn} class="btn btn-primary w-100 py-2" type="submit">입력</button> 
        <button style={btn} class="btn btn-secondary w-100 py-2" type="reset">취소</button> 
        <button style={btn} class="btn btn-secondary w-100 py-2" type="button" onClick={backCB}>뒤로</button> 
    </form>
    </>
  )
}

export default Add