# Intellica-test-task
This is the REST API for Tasks service.
## List of complited features:
  REST API, Validation, Persistence, Address entity.

### WIP list:
  Unit and integration tests, The ability to sort by First Name, Last Name, and Scheduled Date ascending and descending in the list of tasks. Package the service in using docker compose in a docker container.  A basic UI to use the API and interact with the system 

## Compile
```
  maven package
```  
## Run
```
  mvn spring-boot:run
  or
  java -jar target\testtask-1.0.jar
```  

# REST API

## Get list of Tasks
```
GET /task
```
## Create new task
```
POST /task
{
				"title": "Mr",
                "firstName": "Tom",
                "lastName": "Cause",
                "date": "2019-04-11T09:15:49.455",
                "address": {
                    "line1": "Sech Gate str.",
                    "line2": null,
                    "town": "Kyiv",
                    "postcode": "03127"
                }
	
}
```
## Update task
```
PUT /task/758811e7-f230-47a5-a5e9-f6bc5413e74d
	{
                "id": "758811e7-f230-47a5-a5e9-f6bc5413e74d",
                "title": "Mr",
                "firstName": "Jack",
                "lastName": "Sparrow",
                "date": "2019-04-01T09:15:49.455",
                "address": {
                    "line1": "Golden Gate str.",
                    "line2": null,
                    "town": "Kyiv",
                    "postcode": "03127"
                }
}
```
## Delete task
```
DELETE /task/758811e7-f230-47a5-a5e9-f6bc5413e74d
```
