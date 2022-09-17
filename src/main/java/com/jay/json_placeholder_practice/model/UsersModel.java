package com.jay.json_placeholder_practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// @Entity annotation is used to tell Spring that this class is a JPA entity.
@Entity

//public is an access modifier which defines who can access this class.
//class is a Keyword which defines a class in java.
//UsersModel is the name of the class.
public class UsersModel {

    // @Id annotation is used to tell Spring that this field is the primary key.
    @Id
    // @GeneratedValue annotation is used to tell Spring that this field is auto-generated.
    // strategy is used to tell Spring how to generate the value.
    // GenerationType.Auto is used to tell spring to generate the value automatically.
    @GeneratedValue(strategy = GenerationType.AUTO)

    // private is an access modifier which defines who can access this field.
    // Long is a data type which defines that this field can only store numbers.
    // id is the name of the field.
    private Long id;
    // String is a data type which defines that this field can only store text.
    private String name;
    private String username;
    private String email;
    private String website;

    //Default constructor is used to create an object of this class
    //public is an access modifier which defines who can access this method.
    //UsersModel is the name of the class.
    public UsersModel() {
    }

    //public is an access modifier which defines who can access this method.
    //UsersModel is the name of the class.
    //Long id, String name, String username, String email, String website are the parameters of the constructor
    public UsersModel(Long id, String name, String username, String email, String website) {
        //this is a keyword which refers to the current object.
        //id, name, username, email, website is the name of the fields.
        //id, name, username, email, website is the name of the parameters.
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.website = website;
    }

    //public is an access modifier which defines who can access this method.
    // Long is a data type which defines that this method can only return numbers.
    // getId is the name of the method.
    public Long getId() {
        return id;
    }

    //public is an access modifier which define who can see this method.
    //void is a data type which defines that this method does not return anything.
    //setId is the name of the method.
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usernames) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
