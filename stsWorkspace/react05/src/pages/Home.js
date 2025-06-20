import React, { useContext } from 'react'
import Login from './Login';
import { UserContext } from '../service/login';

function Sec({children,user}){
    //const [user,setUser]=useContext(UserContext);
    console.log(children);
    return user=='admin'?<div>{children}</div>:<Login/>;
}

function Test(){
    const {user,setUser}=useContext(UserContext);
    return (
      <Sec user={user}><Test></Test></Sec>
    )
}

function Home() {
    return <h2>index</h2>
}

export default Home;