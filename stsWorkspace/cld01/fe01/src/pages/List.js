import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router';

function List() {
  const [list,setList]=useState([{dname:'test',loc:'test',deptno:0}]);
  const navigate=useNavigate();
  useEffect(()=>{
    fetch('/api/dept/')
      .then(e=>{
        if(e.status==406){
          navigate('/login');
        }else if(e.ok)
          return e.json();
      })
      .then(data=>{
        if(data) setList(data);
      })
      .catch(console.log);
  },[]);

  return (
    <>
      <h2>list page</h2>
      {list.map(ele=>{
        return (
            <div>
              <h3>{ele.dname}</h3>
              <p>[<span>{ele.deptno}</span>] ele.loc</p>
            </div>
        );
      })}
      <Link to={'/dept/add'}>입력</Link>
    </>
  )
}

export default List