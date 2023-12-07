I added a postman collection to make it easy to review the functionality of the application.

The design of the program follows the traditional design of a spring book application, with controller, service, repository layer. Another design that can be used is using Spring Data Rest which exposes Crud operations as Restful apis and provide support for HATEOAS out of the box.
This approach can reduce the boilerplate for small applications but the disadvantage is that it couples the Controller layer and Repository layer together, that’s why I went with the traditional approach.   

What I will do if I have more time?

1- Create a dedicated Controller, Service and an Entity for Session management(login,logout), and separate it from the User controller. 

2- Exception handling.

3- Sliced tests using Mockito and Junit

4- Add logging

Instructions:

1- Call “New User” request in the postman collection (http://localhost:8080/public/user/) to create a new user
![image](https://github.com/samky987/Notes-App/assets/63223538/e41f658c-9fd7-4dca-b00f-1ed639eacd66)

2-Call “New Session” request in the postman collection(http://localhost:8080/public/user/session) to create a new login session, and copy the token returned

![image](https://github.com/samky987/Notes-App/assets/63223538/0adb7df0-56e3-4600-9caf-9cfd4a329409)

3-Replace the token in the Authorization tab with the token you copied from New Session in the requests you want to make.

![image](https://github.com/samky987/Notes-App/assets/63223538/cf8f6fe8-07f4-4cb2-b479-368deb4e84bb)


The token is valid for 12 hours.
