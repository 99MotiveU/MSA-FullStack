import React, { Component } from 'react'

export default class App15 extends Component {

    constructor(){
        super();
        this.state={arr:[]};
    }

    componentDidMount(){
        const result=['item1','item2','item3','item4'];
        const arr=result.map(ele=><li>{ele}</li>);
        this.setState({arr});
    }

  render() {
    return (
      <div>
        <h2>Item</h2>
        <ul>
            {this.state.arr}
        </ul>
      </div>
    )
  }
}
