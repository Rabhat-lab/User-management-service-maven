package com.raksha.usermgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raksha.usermgmt.model.User;

//to be able to talk to an entity first need to create spring data repository
//extend JpaRepository class and tell which entity it has to manage and which is the primary key
//entity = User , primary key= {id}
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	List<User> findByFirstName(String firstName);

}
