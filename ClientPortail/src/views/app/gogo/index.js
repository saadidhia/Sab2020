import React, { Suspense } from 'react';
import { Redirect, Route, Switch } from 'react-router-dom';

const Start = React.lazy(() =>
  import(/* webpackChunkName: "start" */ './start')
);
const Scheduler = React.lazy(() =>
  import(/* webpackChunkName: "start" */ './scheduler')
);
const Portfolio = React.lazy(() =>
import(/* webpackChunkName: "start" */ './portfolio')
);
const Gogo = ({ match }) => (
  <Suspense fallback={<div className="loading" />}>
    <Switch>
      <Redirect exact from={`${match.url}/`} to={`${match.url}/start`} />
      <Route
        path={`${match.url}/start`}
        render={props => <Start {...props} />}
      />

    <Redirect exact from={`${match.url}/`} to={`${match.url}/scheduler`} />
      <Route
        path={`${match.url}/scheduler`}
        render={props => <Scheduler {...props} />}
      />
      <Redirect exact from={`${match.url}/`} to={`${match.url}/portfolio`} />
      <Route
        path={`${match.url}/portfolio`}
        render={props => <Portfolio {...props} />}
      />
      <Redirect to="/error" />
    </Switch>
  </Suspense>
);
export default Gogo;
