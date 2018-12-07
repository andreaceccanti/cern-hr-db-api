# cern-hr-db-service

A simple REST API to query the CERN HR db.

## Brief API description

By default the server listens on port 8080. 

The API resources live under `/api`.

The API support basic authentication. If TLS is required, the API
can be deployed behind a reverse proxy (e.g. NGINX).

### Resources

### VOPerson

#### GET /VOPersons/{personId}

Returns a JSON representation of a VOPerson, given the CERN personId.

#### GET /VOPersons/email/{email}

Returns a JSON representation of a VOPerson, given the person email.

### GET /VOPersons/participation/{experimentName}

Returns a paginated list of participations for an experiment, given the
experiment name. 

The `startIndex` and `count` parameters can be used for pagination.

### GET /VOPersons/participation/{experimentName}/valid

Returns a paginated list of valid participations for an experiment, given
the experiment name.

The `Countries`, `Institutes`, `Experiments` resources work similarly.
