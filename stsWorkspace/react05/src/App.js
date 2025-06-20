import logo from './logo.svg';
import './App.css';
import Layout from './pages/modules/Layout';
import { BrowserRouter, Route, Routes } from 'react-router';
import Home from './pages/Home.js';
import About from './pages/About';
import Login from './pages/Login';
import Register from './pages/Register';
import { createContext, useState } from 'react';
import { UserContext } from './service/login.js';
import LoginCheck from './pages/modules/LoginCheck.js';

function App() {
  const [user,setUser]=useState('guest');
  return (
    <UserContext.Provider value={{user,setUser}}>
    <BrowserRouter>
      <Routes>
        <Route element={<Layout/>}>
          <Route index element={<Home />} />
          
          <Route path='about' element={<LoginCheck user={user}><About/></LoginCheck>} />
        </Route>
        <Route path='/join' element={<Layout/>}>
          <Route path='login' element={<Login/>} />
          <Route path='register' element={<Register  />} />
        </Route>
      </Routes>
    </BrowserRouter>
    </UserContext.Provider>
  );
}

export default App;
