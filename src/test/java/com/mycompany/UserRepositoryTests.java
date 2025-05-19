package com.mycompany;


import com.mycompany.user.CrudRepository;
import com.mycompany.user.User;
import com.mycompany.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.swing.*;
import java.util.Optional;


@Nested
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class userRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("ravi.cumar@gmail.com");
        user.setPassword("ravi123456");
        user.setFirstName("Ravi");
        user.setLastName("Kumar");

        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }


    @Test
    public void testListAll() {
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }


    public UserRepository getRepo() {
        return repo;
    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
       // Optional<User> optionalUser = repo.findById(userId);
        ClassValue<Object> optionalUser = null;
        User user = (User) optionalUser.get(userRepositoryTests.class);
        user.setPassword("hello2000");
        repo.save(user);

        //User updateUser = repo.findById( userId).get();
        JPasswordField updateUser = null;
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("hello2000");
    }

    private Integer userId() {
        System.out.println(repo.findById());


        return 0;
    }

    @Test
    public void testGet() {
        Integer userId = 2;
        CrudRepository repo = null;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println((optionalUser.get()));
    }

    @Test
    public void testDelete() {
        Integer userId = 2;
        CrudRepository<Object, Object> repo = null;
        repo.deleteById(userId);

        Optional<Object> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }

}