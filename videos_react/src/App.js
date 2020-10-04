import React from 'react';
import './App.css';
import { Switch, Route } from "react-router-dom";

import AllVideos from "./components/AllVideos";
import VideoDetails from "./components/VideoDetails";

export default function App() {
  return (
    <div className="App">
      <Switch>
        <Route path="/" exact component={AllVideos} />
        <Route
          path="/video/:id"
          render={(e) => <VideoDetails id={e.match.params.id} />}
        />
      </Switch>
    </div>
  );
}
