package com.mycompany.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CrudRepository <T, Id> extends JpaRepository<T, Id> {

    <S extends T> S save(S entity);

    <S extends T> List<S> saveAll(Iterable<S> var1);

    @Override
    Optional<T> findById(Id var1);

    @Override
    boolean existsById(Id var1);

    boolean create(User user);
    boolean update(User user);
    boolean delete(int id);
    User findById(int id);
    List<T> findAll();




    long count();
    void close();
    void open();
    void closed();
    void deleteAll();
    void deleteById(int id);

    int userCount();
    int getUserCount();
    int userCount(int id);

}
