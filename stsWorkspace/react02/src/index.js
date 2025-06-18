import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import App15 from './App15';

function App3(){
  return <h2>App3 page</h2>;
}

const App4=function(){
  return <h2>App4 page</h2>;
};
const App5=()=>{
  return <h2>App5 page</h2>;
};

function App10(props){
  return <h2>app10 msg={props.msg}</h2>;
}

function App11({msg}){
  return <ul><li>{msg[0]}</li><li>{msg[1]}</li></ul>;
}

class App12 extends React.Component{
  constructor(props){
    super(props);
    this.msg=props.msg;
  }
  render(){
    return (
    <div>
      <h2>App12</h2>
      <p>msg:{this.msg}</p>
    </div>
    );
  }
}

class Car extends React.Component {
  constructor(props) {
    super(props);
    this.state={msg:'abc',su:1234};
  }
  changeColor = () => {
    // this.state='ABC';
    this.setState({...this.state,msg:'ABC'});
  }
  componentDidMount=()=>{
    console.log("mount","componentDidMount");
    
    this.setState({...this.state,result:"result"});
  }
  shouldComponentUpdate(){
    console.log("update","shouldComponentUpdate");
    // return true;
  }
  componentDidUpdate(){
    console.log("update","componentDidUpdate");
  }
  render() {
    return (
      <div>
        <h1>My {this.state.msg}</h1>
        <h2>su: {this.state.su}</h2>
        <h2>result: {this.state.result}</h2>
        <button
          type="button"
          onClick={this.changeColor}
        >Change color</button>
      </div>
    );
  }
}
const h1=React.createElement('h1',null,'msg');
const hr=React.createElement('a',{href:'http://google.com'},'link');
const div=React.createElement('div',null,null,h1,hr);
// React.Children()
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App15/>);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
