import React from "react";
//import Cadastros from "./componentes/Cadastros";
import Vagas from "./componentes/Vagas";

import {
  BrowserRouter,
  Route
} from 'react-router-dom'

  
function App() {
  return (
    <>
      <BrowserRouter>
          <Route path="/" exact component={Vagas}/>
      </BrowserRouter>
    </>
  );
};

export default App;

