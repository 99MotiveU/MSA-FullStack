import React, { useEffect, useState } from 'react'
import { Link } from 'react-router';

function List() {
  const [alist,setAlist] =useState([]);
  useEffect(()=>{
    fetch('/api/')
    .then(e=>e.json())
    .then(json=>{
        setAlist(json);
    })
    .catch(console.error)
  },[]);
  return (
    <>
        <h2 style={{marginTop:'20px'}}>list page</h2>
        <table className='table'>
            <thead>
                <tr>
                    <th>deptno</th>
                    <th>dname</th>
                    <th>location</th>
                </tr>
            </thead>
            <tbody>
                {alist.map(ele=>{
                    return (
                        <tr>
                            <td>{ele.deptno}</td>
                            <td>{ele.dname}</td>
                            <td>{ele.loc}</td>
                        </tr>
                    );
                })}
            </tbody>
        </table>
        <div class="d-grid gap-2">
        <Link to={'./add'} className='btn btn-primary' role='button'>입력</Link>
        </div>
    </>
  )
}

export default List