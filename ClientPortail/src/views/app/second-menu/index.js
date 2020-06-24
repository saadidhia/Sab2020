import React, { Suspense } from 'react';
import { Redirect, Route, Switch } from 'react-router-dom';

const TodoApplicationMenu = React.lazy(() =>
  import(/* webpackChunkName: "second" */ './TodoApplicationMenu')
);
const Client = React.lazy(() =>
  import(/* webpackChunkName: "second" */ './client.js')
);
const SecondMenu = ({ match }) => (
  <Suspense fallback={<div className="loading" />}>
    <Switch>
      <Redirect exact from={`${match.url}/`} to={`${match.url}/TodoApplicationMenu`} />
      <Route
        path={`${match.url}/TodoApplicationMenu`}
        render={props => <TodoApplicationMenu {...props} />}
      />
       <Redirect exact from={`${match.url}/`} to={`${match.url}/clients`} />
      <Route
        path={`${match.url}/clients`}
        render={props => <Client {...props} />}
      />
      <Redirect to="/error" />
    </Switch>
  </Suspense>
);
export default SecondMenu;
