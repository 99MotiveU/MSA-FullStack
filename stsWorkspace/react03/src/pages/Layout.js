import React from 'react'
import { NavLink, Outlet } from 'react-router-dom'

export default function Layout() {
  return (
    <div>
        <nav>
            <NavLink to='/'>home</NavLink>
            <NavLink to='/blogs'>blogs</NavLink>
            <NavLink to='/contact'>contact</NavLink>
        </nav>
        <div className='container'>
            <Outlet/>
        </div>
    </div>
  )
}
