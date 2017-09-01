import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
//import registerServiceWorker from './registerServiceWorker';
import { BrowserRouter, Route } from 'react-router-dom';

ReactDOM.render(
    <BrowserRouter>
        <div>
            <Route path="/" component={App} />
        </div>
    </BrowserRouter>
    , document.getElementById('root'));
//registerServiceWorker(); dont need service worker because want to debug spring hosting this on every page
