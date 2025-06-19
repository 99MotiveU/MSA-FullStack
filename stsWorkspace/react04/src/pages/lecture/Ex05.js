import React, { useState, Fragment } from 'react'

function Ex06(props){
    console.log(props);
    const obj={k1:'v1'};
    return(
        <Fragment>
            <h2>{props.msg}</h2>
            <button onClick={e=>{
                props.func('수정');
            }}>btn</button>
        </Fragment>
    );
}

function Ex05() {
    const [title, setTitle]=useState('ex05');
  const func=(e)=>{
    console.log('함수 전달',e);
    setTitle(e);
  };
  return (
    <>
        <h1>{title}</h1>
        <Ex06 msg="ex06" func={func}/>
    </>
  )
}

export default Ex05