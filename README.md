# UserService_SpringBoot

#SignUp Servive:
http://localhost:8080/api/register
#Json:
{
  "name": "Name",
  "email": "Name@gmail.com",
  "password": "password"
}

Login for get Access Token:
http://localhost:8080/api/login
#Json:
{
  "email": "Name@gmail.com",
  "password": "password"
}

User Service :
1)GetAll:
http://localhost:8080/user/getall
2)Create User:
http://localhost:8080/user/add

#Json
  {
        "id": "12",
        "name": "Name",
        "email": "Name@gmail.com"
    }
    
3)GetByID:
http://localhost:8080/user/getbyid?Id=123
Pass the ID in Request Param

4)Update
http://localhost:8080/user/update

#Json
 {
        "id": "12", // Existing ID
        "name": "NewName",
        "email": "NewemailName@gmail.com"
    }

 5) Delete by ID:
 http://localhost:8080/user/delete?Id=1235
Pass the ID in Request Param
   

    
