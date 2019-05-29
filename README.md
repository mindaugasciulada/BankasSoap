# Bankas

## How to run

### Installing

What things you need to install the software and how to install them

```
docker build -t webservisai/soap:latest .

docker run --rm -d -p 80:5000 webservisai/soap:latest

OR using docker-compose

docker-compose up -d
```

### Accessibility


```
localhost:5000
internet: 193.219.12.42
```


### Get All Users
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://localhost/ws/user">
   <soapenv:Header/>
   <soapenv:Body>
      <user:getAllUsers/>
   </soapenv:Body>
</soapenv:Envelope>

```
### Get User
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://localhost/ws/user">
   <soapenv:Header/>
   <soapenv:Body>
      <user:getUser>
         <userId>?</userId>
      </user:getUser>
   </soapenv:Body>
</soapenv:Envelope>
```

### Delete User
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://localhost/ws/user">
   <soapenv:Header/>
   <soapenv:Body>
      <user:deleteUser>
         <userId>?</userId>
      </user:deleteUser>
   </soapenv:Body>
</soapenv:Envelope>
}
```

### Search User balance (returns object)
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://localhost/ws/user">
   <soapenv:Header/>
   <soapenv:Body>
      <user:searchUserBalanceObject>
         <balance>?</balance>
      </user:searchUserBalanceObject>
   </soapenv:Body>
</soapenv:Envelope>
```

### Add course
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://localhost/ws/user">
   <soapenv:Header/>
   <soapenv:Body>
      <user:addCourse>
         <UserId>?</UserId>
         <CourseId>?</CourseId>
      </user:addCourse>
   </soapenv:Body>
</soapenv:Envelope>
```

### Delete Course
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://localhost/ws/user">
   <soapenv:Header/>
   <soapenv:Body>
      <user:deleteCourse>
         <userId>1</userId>
         <CourseId>2</CourseId>
      </user:deleteCourse>
   </soapenv:Body>
</soapenv:Envelope>
```

### Search User name (returns suggestions)
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://localhost/ws/user">
   <soapenv:Header/>
   <soapenv:Body>
      <user:searchUserName>
         <name>?</name>
      </user:searchUserName>
   </soapenv:Body>
</soapenv:Envelope>
```

### Search User name (returns object)
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://localhost/ws/user">
   <soapenv:Header/>
   <soapenv:Body>
      <user:searchUserName>
         <name>?</name>
      </user:searchUserName>
   </soapenv:Body>
</soapenv:Envelope>
```
