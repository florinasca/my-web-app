package com.mycompany.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository <User, Integer> {

    <Interger> Optional<User> findById(Integer id);

    //boolean findById(void  attr0);

    boolean findById();
}
