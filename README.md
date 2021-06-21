How to hit the local swagger :
1. the default server for any spring boot application is tomcat . Bring the tomcat server from your localhost up
2. hit the url : http://localhost:8080/swagger-ui.html
3. this gives the complete methods and request and endpoints
4. to check the health and other information about the application from your local ; hit the actuator url
5. the actuator url is : http://localhost:8080/actuator/health

How to check the h2 console :
1. hit http://localhost:8080/h2-console
2. make sure you have jdbc url as : jdbc:h2:mem:testdb
3. Use Generic H2 embeded
4. connect
5. run : select * from user -> should get all the users inserted from data.sql present in resources folder
