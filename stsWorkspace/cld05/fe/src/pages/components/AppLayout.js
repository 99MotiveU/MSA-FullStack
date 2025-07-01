import React from 'react'
import { Link, Outlet } from 'react-router'

function AppLayout() {
  const navli={marginRight:'10px'};
  return (
    <>
    <nav>
        <Link style={navli} to={'/'}>home</Link>
        <Link style={navli} to={'/dept'}>dept</Link>
        <Link style={navli} to={'/emp'}>emp</Link>
        <Link style={navli} to={'/join'}>join</Link>
        <Link style={navli} to={'/login'}>login</Link>
        <Link to={'/logout'}>logout</Link>
    </nav>
    <Outlet/>
    </>
  )
}

export default AppLayout