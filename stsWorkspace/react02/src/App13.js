import React, { Component } from 'react'

export default class App13 extends Component {

    constructor(props){
        super(props);
        this.state={msg:'',show:'none'};
    }

    func01=()=>{
        alert(this.state.msg);
        this.setState({...this.state,show:''});
    };
    func02=(e)=>{
        const val=this.state.msg+e.target.val;
        this.setState({...this.state,msg:val});
    };

  render() {
    return (
      <div>
        <input onChange={this.func02} value={this.state.msg}/>
        <button onClick={this.func01}>클릭</button>
        <div style={{display:this.state.show}} id='target'>{this.state.msg}</div>
      </div>
    )
  }
}
