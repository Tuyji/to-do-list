package com.hepsiemlak.assignment.repository;

import com.hepsiemlak.assignment.entity.ToDo;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, String> {

    @Query("#{#n1ql.selectEntity} WHERE role = 'admin' AND #{#n1ql.filter}")
    List<ToDo> findAllTodos();
}
