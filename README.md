# Movie REST Service 

Created basic REST services and endpoints for a movie application using SpringBoot and tested using postman.

## Setting Up docker and mysql;

1. We pull mysql docker image from Docker Hub using
	```	
		docker pull mysql
	```
2. Create a running "docker-mysql" container 
	```
		sudo docker run -d --name docker-mysql -p 3306:3306 --network=host -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=movieDB -e MYSQL_USER=root-app -e MYSQL_PASSWORD=root123 mysql
	```

Note that the username is root-app and the password is root123

3. check if mysql container is working,
	```
		sudo docker exec -it docker-mysql bash
	```
	and check if the user name and password is working 
	```
		mysql -u root-app -p
	```
4. Create a Dockerfile , with contents matching with that of your project.
5. Build the Docker image using 
	```
		sudo docker build -t movie-app .
	```
6. Run the docker image "movie-app" using
	```
		sudo docker run --name movie-app --network=host movie-app
	```
7. Check your docker database is working according to your logic.
