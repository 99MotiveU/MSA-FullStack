import React, { useEffect, useState } from 'react'
import { Link } from 'react-router';

function List() {
    const [arr,setArr]=useState([]);
    useEffect(()=>{
        fetch('/api/v1/dept/')
            .then(e=>e.json())
            .then(json=>setArr(json))
            .catch(console.log);
    },[]);
  return (
    <>
        <h2>list page</h2>
        <ul>
            {arr.map((ele,idx)=>{
                return (
                    <li key={idx}>[{ele.deptno}][{ele.dname}][{ele.loc}]</li>
                );
            })}
        </ul>
        <Link to={'/dept/add'}>입력</Link>
    </>
  )
}

export default List