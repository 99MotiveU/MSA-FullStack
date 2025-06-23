import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router';
import Home from './pages/Home';
import Intro from './pages/Intro';
import List from './pages/List';
import Add from './pages/Add';
import Dept from './pages/Dept';
import Login from './pages/Login';
import Join from './pages/Join';
import Layout from './pages/components/Layout';
import { LoginContext } from './pages/components/loginContext';
import { useState } from 'react';
import Logout from './pages/Logout';



function App() {
  const [login,setLogin]=useState({result:false,id:'guest'});
  return (
    <LoginContext.Provider value={{login,setLogin}}>
    <BrowserRouter>
      <Routes>
        <Route element={<Layout login={login}/>}>
          <Route index element={<Home/>}/>
          <Route path='/intro' element={<Intro/>}/>
        </Route>
        <Route path='/dept' element={<Layout login={login}/>}>
          <Route index element={<List/>}/>
          <Route path='add' element={<Add/>}/>
          <Route path=':deptno' element={<Dept/>}/>
        </Route>
        <Route path='/login' element={<Layout login={login}/>}>
          <Route index element={<Login/>}/>
          <Route path='join' element={<Join/>}/>
          <Route path='logout' element={<Logout/>}/>
        </Route>
      </Routes>
    </BrowserRouter>
    </LoginContext.Provider>
  );
}

export default App;
