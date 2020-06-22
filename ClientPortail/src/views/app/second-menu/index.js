import React, { Suspense } from 'react';
import { Redirect, Route, Switch } from 'react-router-dom';

const TodoApplicationMenu = React.lazy(() =>
  import(/* webpackChunkName: "second" */ './TodoApplicationMenu')
);
const SecondMenu = ({ match }) => (
  <Suspense fallback={<div className="loading" />}>
    <Switch>
      <Redirect exact from={`${match.url}/`} to={`${match.url}/TodoApplicationMenu`} />
      <Route
        path={`${match.url}/TodoApplicationMenu`}
        render={props => <TodoApplicationMenu {...props} />}
      />
      <Redirect to="/error" />
    </Switch>
  </Suspense>
);
export default SecondMenu;
