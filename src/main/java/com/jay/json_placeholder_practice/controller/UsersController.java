package com.jay.json_placeholder_practice.controller;

import com.jay.json_placeholder_practice.model.UsersModel;
import com.jay.json_placeholder_practice.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

//@ResController is an annotation which is used to tell spring that this class is a controller.
@RestController
//("/json-placeholder") is a request mapping which is used to map the url to the controller class.
@RequestMapping("/json-placeholder")
public class UsersController {

    //@Autowired is an annotation which is used to tell spring that this field is autowired, and it will be injected automatically.
    @Autowired
    //private is an access modifier which defines who can access this field.
    //UsersRepo is a class which is used to perform CRUD operations on a database.
    //usersRepo is the name of the field.
    private UsersRepo usersRepo;

    //private is an access modifier which defines who can access this field.
    //final is a keyword which is used to define a constant.
    //String is a data type which defines that this field can only store text.
    //url is the name of the field.
    //https://jsonplaceholder.typicode.com/users is the value of the field.
    private final String url = "https://jsonplaceholder.typicode.com/users";

    //@GetMapping is an annotation which is used to tell spring that this method is a get mapping.
    //("/users") is a request mapping which is used to map the url to the controller class.
    @GetMapping("users")
    //public is an access modifier which defines who can access this method.
    //ResponseEntity is a class which is used to send a response to the client with a status code.
    //<?> is a wildcard which defines that this method can return any type of data.
    //getUsers is the name of the method.
    //RestTemplate is a class which is used to send a request to an url.
    //restTemplate is the name of the field.
    public ResponseEntity<?> getUsers(RestTemplate restTemplate){

        //UsersModel[] is a data type which defines that this field can only store an array of UsersModel.
        //users is the name of the field.
        //restTemplate is the name of the field.
        //getForObject is a method which is used to send a get request to an url.
        //url is the name of the field.
        //UsersModel[].class is a class which is used to define the structure of the table.
        // It is used to convert the json response to a java object.
        // It is also used to convert the java object to a json response.
        // it is also used to convert the json response to a java array.
        // It is also used to convert the java array to a json response.
        // It is also used to convert the json response to a java list.
        UsersModel[] users = restTemplate.getForObject(url, UsersModel[].class);

        //for is a keyword which is used to create a for loop.
        //UsersModel is a class which is used to define the structure of the table.
        //user is the name of the field.
        //users is the name of the field.
        for(UsersModel user : users) {
            //usersRepo is the name of the field.
            //save is a method which is used to save a record in a database.
            //user is the name of the field.
            usersRepo.save(user);
        }

        //return is a keyword which is used to return a value from a method.
        //ResponseEntity is a class which is used to send a response to the client with a status code.
        //ok is a method which is used to send a response to the client with a status code of 200.
        //usersRepo is the name of the field.
        //findAll is a method which is used to get all the records from a database.
        return ResponseEntity.ok(usersRepo.findAll());
    }

    //@PostMapping is an annotation which is used to tell spring that this method is a post mapping. It is used to create a record in a database table. It is used to create a new user. It is used to create a new post.
    //("/create) is a request mapping which is used to map the url to the controller class.
    @PostMapping("/create")
    //public is an access modifier which defines who can access this method.
    //ResponseEntity is a class which is used to send a response to the client with a status code.
    //<UsersModel> is a wildcard which defines that this method can return any type of data.
    //createUsers is the name of the method.
    //@RequestBody is an annotation which is used to tell spring that this parameter is a request body. It is used to get the data from the request body.
    //UsersModel is a class which is used to define the structure of the table.
    //newUsersModel is the name of the parameter.
    public ResponseEntity<UsersModel> createUsers (@RequestBody UsersModel newUsersModel) {
        //return is a keyword which is used to return a value from a method.
        //new is a keyword which is used to create a new object.
        //ResponseEntity is a class which is used to send a response to the client with a status code.
        //usersRepo is the name of the field.
        //save is a method which is used to save a record in a database.
        //newUsersModel is the name of the parameter.
        //HttpStatus is an enum which is used to define the status code of the response.
        //CREATED is a constant which is used to define the status code of the response.
        return new ResponseEntity<>(usersRepo.save(newUsersModel), HttpStatus.CREATED);
    }


}
