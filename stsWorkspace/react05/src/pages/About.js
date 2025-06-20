import userEvent from '@testing-library/user-event';
import React, { createContext, useContext, useEffect, useReducer, useState } from 'react'
import { UserContext } from '../App';
import { initialTodos, reducer } from '../service/Count';

function About() {
  const [todos, dispatch] = useReducer(reducer, initialTodos);
  return (
    <><h2>{todos}</h2>
      <button onClick={e=>dispatch({ type: 'plus', payload: 10 })}>plus</button>
      <button onClick={e=>dispatch({ type: 'minus', payload: 10 })}>minus</button>
    </>
  );
}

export default About