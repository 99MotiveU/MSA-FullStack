import React, { Component } from 'react'
import data from '../dummy';
import { Link } from 'react-router-dom';

export default class Blogs extends Component {

    componentDidMount(){
        const arr=data.map(ele=>{
            return (
                <tr key={ele.num}>
                    <td>{ele.num}</td>
                    <td>{ele.sub}</td>
                    <td>{ele.id}</td>
                    <td>{ele.nalja}</td>
                </tr>
            );
        });
        this.setState({arr});
    }

  render() {
    return (
      <div>
      <h1>Blogs</h1>
      <table className='table'>
        <thead>
            <tr>
                <th style={{width:'80px'}}>글번호</th>
                <th>내용</th>
                <th style={{width:'80px'}}>작성자</th>
                <th style={{width:'80px'}}>날짜</th>
            </tr>
        </thead>
        <tbody>
            {this.state?this.state.arr:null}
        </tbody>
      </table>
      <Link to={'/blogs/add'} className='btn btn-primary btn-block' role='button'>입력</Link>
    </div>
    )
  }
}
