# GamingLads-profile-service
This service takes care of all the profiles from the users.
All documentation can be found in gaminglads-gateway -> documentation

## api endpoints
##### create profile
````http request
POST/profile/create
````
Returns a ResponseEntity with status CREATED if succeeded or CONFLICT if failed

##### update profile
````http request
PUT/profile/update
````
Returns a responseEntity with status OK if succeeded or CONFLICT if failed


##### get all profiles
````http request
GET/profile/all
````
Returns a responseEntity with a list of profiles and status OK if succeeded or null and CONFLICT if failed

