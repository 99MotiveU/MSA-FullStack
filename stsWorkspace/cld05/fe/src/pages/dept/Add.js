import React from 'react'
import { useNavigate } from 'react-router';

function Add() {
    const navigate=useNavigate();
    const cb=e=>{
        e.preventDefault();
        fetch('/api/v1/dept/',{
            method: "POST"
            ,headers:{
                "Content-Type": "application/json",
            }
            ,body:JSON.stringify({deptno:0,dname:e.target.dname.value,loc:e.target.loc.value})
        }).then(e=>{
            if(e.ok) navigate('/dept/'); 
        });
    };
  return (
    <>
        <h2>입력 페이지</h2>
        <form onSubmit={cb}>
            <div>
                <label></label><input name='dname'/>
            </div>
            <div>
                <label></label><input name='loc'/>
            </div>
            <div>
                <button>입력</button>
            </div>
        </form>
    </>
  )
}

export default Add