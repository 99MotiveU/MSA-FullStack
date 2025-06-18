import React, { Component } from 'react'

class Login extends Component{
    render(){
        return <h3>login</h3>;
    }
}
class Logout extends Component{
    render(){
        return <h3>logout</h3>;
    }
}


export default class App14 extends Component {
    constructor(){
        super();
        this.state={login:true};
    }
  render() {
    // let show=null;
    // if(this.state.login){
    //     show=<Login/>;
    // }else{
    //     show=<Logout/>
    // }
    return (
      <div>
        {this.state.login?<Login/>:<Logout/>}
        <button onClick={()=>{this.setState({login:!this.state.login})}}>클릭</button>
      </div>
    )
  }
}
