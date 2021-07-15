* step1: clone projet from github
https://github.com/mfallgithub/managementUser.git
* step 2: build project with this command
mvn clean install
* step3 : you can run the project after building it with this command
mvn spring-boot:run
* step 4: after running projet
 + 4-1 : go on swagger with url 
   http://localhost:8080/swagger-ui.html
 + 4-2 : register a user like this in swagger on 
* this is an exemple to register user
*
{
"username": "mfall",
"birthdate": "2021-01-01T00:00:00.000+00:00",
"country": "senegal1",
"phoneNumber": null,
"gender": null
}
*
 + 4-3 : after register a user you can go on the db h2
 * url is : http://localhost:8080/h2-ui/login.jsp?jsessionid=ed55950b5cd1a18ad136d06f1f0d087e

and you verify if the user is registed
+ 4-4 : you can test the other by using the username on swagger
if it exists you can see that if not you will have an exception
* NB: it's possible to test with Postman   
  

