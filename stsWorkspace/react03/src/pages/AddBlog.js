import React, { Component } from 'react'
import data from '../dummy';
import { useLocation, useNavigate } from 'react-router-dom';

export default function AddBlog() {
    let navigate = useNavigate();
    const bck=()=>{
        navigate(-1);
    };
    const func=(e)=>{
        e.preventDefault();
        console.log(e.target.sub.value);
        console.log(e.target.id.value);
        console.log(e.target.content.value);
        const max=data.reduce((a,b,c,d)=>{
            console.log(typeof a,typeof b);
            let before=(typeof a)=='object'?a.num:a;
            let after=(typeof b)=='object'?b.num:b;
            return before>after?before:after});
        data.push({
            num:max+1,
            sub:e.target.sub.value,
            content:e.target.content.value,
            id:e.target.id.value,
            nalja:new Date().toJSON()
        });
        navigate("/blogs");
    };
    return (
      <div>
        <h1 className='text-header'>블로그 글쓰기</h1>
        <form onSubmit={(e)=>func(e)}>
            <label style={{display:'block'}} className='form-group'>
                <input name='sub' className='form-control' placeholder='제목'/>
            </label>
            <label style={{display:'block'}} className='form-group'>
                <input name='id' className='form-control' placeholder='글쓴이'/>
            </label>
            <label style={{display:'block'}} className='form-group'>
                <textarea name='content' className='form-control' placeholder='내용'/>
            </label>
            <button type='submit' className='btn btn-primary btn-block'>입력</button>
            <button type='reset' className='btn btn-default btn-block'>취소</button>
            <button type='button' onClick={bck} className='btn btn-default btn-block'>뒤로</button>
        </form>
      </div>
    )
}
