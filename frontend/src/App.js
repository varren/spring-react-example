import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import {NavLink} from 'react-router-dom'

class App extends Component {
    render() {
        console.log(this.props)
        return (
            <div className="App">
                <div className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h2>Welcome to React</h2>
                </div>
                <p>
                    <p><NavLink to={"./store" }>store</NavLink></p>
                    <p><NavLink to={"./blog" }>blog</NavLink></p>
                    <p><NavLink to={"./index.html" }>main</NavLink></p>
                </p>
                <p>

                </p>
            </div>
        );
    }
}

export default App;
