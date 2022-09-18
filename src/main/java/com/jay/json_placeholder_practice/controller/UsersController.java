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
    public ResponseEntity<?> getUsers(RestTemplate restTemplate) {

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
        for (UsersModel user : users) {
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
    public ResponseEntity<UsersModel> createUsers(@RequestBody UsersModel newUsersModel) {
        //return is a keyword which is used to return a value from a method.
        //new is a keyword which is used to create a new object.
        //ResponseEntity is a class which is used to send a response to the client with a status code.
        //usersRepo is the name of the field. It is used to perform CRUD operations on a database.
        //save is a method which is used to save a record in a database.
        //newUsersModel is the name of the parameter.
        //HttpStatus is an enum which is used to define the status code of the response.
        //CREATED is a constant which is used to define the status code of the response.
        return new ResponseEntity<>(usersRepo.save(newUsersModel), HttpStatus.CREATED);
    }

    @GetMapping("/allusers")
    public ResponseEntity<Iterable<UsersModel>> getAllAccounts() {
        //Iterable is an interface which is used to define a collection of objects. It is used to define a collection of UsersModel.
        //<UsersModel> is a wildcard which defines that this method can return any type of data. It is used to define a collection of UsersModel.
        //accountAppModels is the name of the field. It is used to store the collection of UsersModel.
        //= is an assignment operator which is used to assign a value to a field.
        //usersRepo is the name of the field. It is used to get all the records from a database.
        //findAll is a method which is used to get all the records from a database.
        Iterable<UsersModel> accountAppModels = usersRepo.findAll();
        //return is a keyword which is used to return a value from a method.
        //new is a keyword which is used to create a new object.
        //ResponseEntity is a class which is used to send a response to the client with a status code.
        //<> is a wildcard which defines that this method can return any type of data. It is used to define a collection of UsersModel.
        //accountAppModels is the name of the field. It is used to store the collection of UsersModel.
        //HttpStatus is an enum which is used to define the status code of the response.
        //ok is a method which is used to send a response to the client with a status code of 200.
        return new ResponseEntity<>(accountAppModels, HttpStatus.OK);
    }

    // delete a user by id and then return the response body with the record that was deleted
    // @DeleteMapping is an annotation which is used to tell spring that this method is a deleted mapping. It is used to delete a record from a database table.
    // ("/delete/{id}") is a request mapping which is used to map the url to the controller class. It is used to map the id to the controller class.
    @DeleteMapping("/deleteuser/{id}")
    //public is an access modifier which defines who can access this method.
    //ResponseEntity is a class which is used to send a response to the client with a status code.
    //<UsersModel> is a wildcard which defines that this method can return any type of data. It is used to define a collection of UsersModel.
    //deleteUser is the name of the method.
    //@PathVariable is an annotation which is used to tell spring that this parameter is a path variable. It is used to get the data from the url.
    //(value = "id") is a request parameter which is used to get the data from the url.
    //UsersModel is a class which is used to define the structure of the table.
    //usersModel is the name of the parameter.
    public ResponseEntity<UsersModel> deleteUser(@PathVariable(value = "id") UsersModel usersModel) {
        //usersRepo is tne name of the field. It is used to perform CRUD operations on a database.
        //delete is a method which is used to delete a record from a database.
        //usersModel is the name of the parameter.
        usersRepo.delete(usersModel);
        //return is a keyword which is used to return a value from a method.
        //new is a keyword which is used to create a new object.
        //ResponseEntity is a class which is used to send a response to the client with a status code.
        //<> is a wildcard which defines that this method can return any type of data. It is used to define a collection of UsersModel.
        //usersModel is the name of the parameter.
        //HttpStatus is an enum which is used to define the status code of the response.
        //ok is a method which is used to send a response to the client with a status code of 200.
        return new ResponseEntity<>(usersModel, HttpStatus.OK);
    }


    //@PutMapping is an annotation which is used to tell spring that this method is a put mapping. It is used to update a record in a database table.
    //("/update/{id}") is a request mapping which is used to map the url to the controller class. It is used to map the id to the controller class.
    @PutMapping("/updateuser/{id}")
    //public is an access modifier which defines who can access this method.
    //ResponseEntity is a class which is used to send a response to the client with a status code.
    //<UsersModel> is a wildcard which defines that this method can return any type of data. It is used to define a collection of UsersModel.
    //updateUser is the name of the method.
    //@PathVariable is an annotation which is used to tell spring that this parameter is a path variable. It is used to get the data from the url.
    //(value = "id") is a request parameter which is used to get the data from the url.
    //UsersModel is a class which is used to define the structure of the table.
    //usersModel is the name of the parameter.
    //@RequestBody is an annotation which is used to tell spring that this parameter is a request body. It is used to get the data from the request body.
    //UsersModel is a class which is used to define the structure of the table.
    public ResponseEntity<UsersModel> updateUser(@PathVariable(value = "id") UsersModel usersModel, @RequestBody UsersModel newUsersModel) {

        //UsersModel is a class which is used to define the structure of the table.
        //updatedUsersModel is the name of the field. It is used to store the updated record.
        //= is an assignment operator which is used to assign a value to a field.
        //usersRepo is the name of the field. It is used to perform CRUD operations on a database.
        //findById is a method which is used to get a record from a database.
        //usersModel is the name of the parameter. It is used to get the id of the record.
        //getId is a method which is used to get the id of the record.
        //get is a method which is used to get the value of the field.
        UsersModel updatedUsersModel = usersRepo.findById(usersModel.getId()).get();

        //usersModel is the name of the parameter.
        //setName is a method which is used to set the name of the record.
        //newUsersModel is the name of the parameter.
        //getName is a method which is used to get the name of the record.
        usersModel.setName(newUsersModel.getName());
        //usersModel is the name of the parameter.
        //setEmail is a method which is used to set the email of the record.
        //newUsersModel is the name of the parameter.
        //getEmail is a method which is used to get the email of the record.
        usersModel.setUsername(newUsersModel.getUsername());
        //usersModel is the name of the parameter.
        //setEmail is a method which is used to set the email of the record.
        //newUsersModel is the name of the parameter.
        //getEmail is a method which is used to get the email of the record.
        usersModel.setEmail(newUsersModel.getEmail());
        //usersModel is the name of the parameter.
        //setWebsite is a method which is used to set the website of the record.
        //newUsersModel is the name of the parameter.
        //getWebsite is a method which is used to get the website of the record.
        usersModel.setWebsite(newUsersModel.getWebsite());

        //UsersModel is a class which is used to define the structure of the table.
        //updateUser is the name of the field. It is used to store the updated record.
        //= is an assignment operator which is used to assign a value to a field.
        //usersRepo is the name of the field. It is used to perform CRUD operations on a database.
        //save is a method which is used to save a record in a database.
        //updateUsersModel is the name of the parameter.
        UsersModel updatedUser = usersRepo.save(updatedUsersModel);

        //return is a keyword which is used to return a value from a method.
        //new is a keyword which is used to create a new object.
        //ResponseEntity is a class which is used to send a response to the client with a status code.
        //<> is a wildcard which defines that this method can return any type of data. It is used to define a collection of UsersModel.
        //updatedUser is the name of the parameter.
        //HttpStatus is an enum which is used to define the status code of the response.
        //ok is a method which is used to send a response to the client with a status code of 200.
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}