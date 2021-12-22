import logo from './logo.svg';
import React, { useState, useEffect} from 'react';
import './App.css';
import REACTDOM from "react-dom";
import UserComponent from './components/UserComponent';


function App() {
  return (
    <div className="App">
      <UserComponent/>
    </div>
  );
}

export default App;
