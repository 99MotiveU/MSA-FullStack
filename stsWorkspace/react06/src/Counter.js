import React from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { decrement, increment, incrementByAmount } from './features/counter/counterSlice'

export function Counter() {
  const count = useSelector((state) => state.counter.value)
  const color = useSelector((state) => state.counter.color)
  const dispatch = useDispatch()

  return (
    <div>
      <div>
        <button
          aria-label="Increment value"
          onClick={() => dispatch(increment())}
        >
          Increment
        </button>
        <span>{count}</span>
        <button
          aria-label="Decrement value"
          onClick={() => dispatch(decrement())}
        >
          Decrement
        </button>
        <button
          aria-label="incrementByAmount value"
          onClick={() => dispatch(incrementByAmount({su:10,color:'blue'}))}
        >
          Decrement
        </button>
        <div style={{color:color}}>asdfasdfdsfsafd</div>
      </div>
    </div>
  )
}