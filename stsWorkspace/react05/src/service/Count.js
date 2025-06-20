export const initialTodos = 0;
export const reducer = (state, action) => {
  console.log('reducer',state, action);
  if(action.type=='plus')
    return state+action.payload;
  if(action.type=='minus')
    return state-action.payload;
};