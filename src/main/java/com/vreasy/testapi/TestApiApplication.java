package com.vreasy.testapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"repository"})
@SpringBootApplication
public class TestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
	}

	
//	# issues a GET request to retrieve listings with no JWT
//	# HTTP 403 Forbidden status is expected
//	curl http://localhost:8080/listings
//
//	# registers a new user
//	curl -H "Content-Type: application/json" -X POST -d '{
//	    "username": "admin",
//	    "password": "password"
//	}' http://localhost:8080/users/sign-up
//
//	# logs into the application (JWT is generated)
//	curl -i -H "Content-Type: application/json" -X POST -d '{
//	    "username": "admin",
//	    "password": "password"
//	}' http://localhost:8080/login
//
//	# issue a POST request, passing the JWT, to create a listing
//	# remember to replace xxx.yyy.zzz with the JWT retrieved above
//	curl -H "Content-Type: application/json" \
//	-H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU1MDA4MDYyM30.VYLU9iopn-3dkSZ9K5k1BvzUlzl-F1PNzuE6XPMu4HHHlnVOYBXFohn_0nXzbVCWdtIdfIBzprATIPB0r7klOA" \
//	-X POST -d '{
//	    "title": "My apartment"
//	}'  http://localhost:8080/listings
//
//	# issue a new GET request, passing the JWT
//	# remember to replace xxx.yyy.zzz with the JWT retrieved above
//	curl -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU1MDA4MDYyM30.VYLU9iopn-3dkSZ9K5k1BvzUlzl-F1PNzuE6XPMu4HHHlnVOYBXFohn_0nXzbVCWdtIdfIBzprATIPB0r7klOA" http://localhost:8080/listings
	
	
	
	
	
	
	
}

