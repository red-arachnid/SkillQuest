import { useState, useEffect } from 'react';

const App = () => {
  return (
    <div> 
      <h1 className="test1">HELLO</h1>
      <h1 className="test2">Everyone</h1>

      <div className="flex">
        <div className="border1"></div>
        <div className="border2"></div>
      </div>

      <div className="flex">
        <div className="shadow1"></div>
        <div className="shadow2"></div>
      </div>

      <div className="flex">
        <div className="colorbox b1"></div>
        <div className="colorbox b2"></div>
        <div className="colorbox b3"></div>
        <div className="colorbox b4"></div>
        <div className="colorbox b5"></div>
        <div className="colorbox b6"></div>
        <div className="colorbox b7"></div>
        <div className="colorbox b8"></div>
        <div className="colorbox b9"></div>
      </div>


    </div>
  );
};

export default App;