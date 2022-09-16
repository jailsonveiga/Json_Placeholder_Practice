package com.jay.json_placeholder_practice.repository;

import com.jay.json_placeholder_practice.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

//public is an access modifier which defines who can access this interface.
//interface is a keyword which defines an interface in java.
//UsersRepo id the name of the interface.
//extends are a keyword which is used to extend a class or interface
//JpaRepository is a class which is used to perform CRUD operations on a database.
//UserModel is a class which is used to define the structure of the table.
//Long is a data type which defines that this interface can only store numbers.
public interface UsersRepo extends JpaRepository<UsersModel, Long> {

}

