import React, { use, useContext } from 'react'
import { LoginContext } from './components/loginContext';

function Login() {
  // const {login,setLogin}=useContext(LoginContext);
  const {login,setLogin}=use(LoginContext);
  
  const logoutSubmit=()=>{
    setLogin({result:false,id:'guest'});
  };
  const loginSubmit=e=>{
    e.preventDefault();

    fetch(`/api/user/?name=${e.target.id.value}&pw=${e.target.pw.value}`)
    .then(e=>e.json()).then(e=>{
      setLogin({...login,result:true,id:e.name,email:e.email,num:e.num});
    }).catch(console.log);
  };
  return login.result?(
    <>
      <h2>logout page</h2>
      <button onClick={e=>{logoutSubmit()}}>logout</button>
    </>
  ):(
    <>
      <h2>login page</h2>
      <form onSubmit={e=>{loginSubmit(e)}}>
        <div>
          <label>id</label>
          <input name='id'/>
        </div>
        <div>
          <label>pw</label>
          <input name='pw'/>
        </div>
        <div>
          <button>로그인</button>
          <button type='button' onClick={e=>{}}>회원가입</button>
        </div>
      </form>
    </>
  )
}

export default Login