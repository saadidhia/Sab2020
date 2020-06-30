import React, { Suspense } from 'react';
import { Redirect, Route, Switch } from 'react-router-dom';

const CollaborateurList = React.lazy(() =>
  import(/* webpackChunkName: "product-data-list" */ './collaborateurs/collaborateur-list')
);

const PagesUsers = ({ match }) => (
  <Suspense fallback={<div className="loading" />}>
    <Switch>
    <Redirect exact from={`${match.url}/`} to={`${match.url}/collaborateurs`} />
      <Route
        path={`${match.url}/collaborateurs`}
        render={props => <CollaborateurList {...props} />}
      />      
      <Redirect to="/error" />
    </Switch>
  </Suspense>
);
export default PagesUsers;