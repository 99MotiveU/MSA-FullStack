import React from 'react'
import { Link, Outlet } from 'react-router'

function Layout() {
  return (
    <>
        <nav>
            <Link to={'/'}>home</Link>
            <Link to={'/about'}>about</Link>
            <Link to={'/dept/'}>dept</Link>
            <Link to={'/join/login'}>login</Link>
        </nav>
        <Outlet/>
    </>
  )
}

export default Layout