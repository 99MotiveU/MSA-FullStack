import React from 'react'
import Login from '../Login'

function LoginCheck({children,user}) {
  return user=='admin'?<div>{children}</div>:<Login/>;
}

export default LoginCheck