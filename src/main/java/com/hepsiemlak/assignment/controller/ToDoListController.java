package com.hepsiemlak.assignment.controller;

import com.hepsiemlak.assignment.model.ToDoAddRequestModel;
import com.hepsiemlak.assignment.model.ToDoResponseModel;
import com.hepsiemlak.assignment.model.ToDoUpdateRequestModel;
import com.hepsiemlak.assignment.service.ToDoListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/todolist")
public class ToDoListController {


    private final ToDoListService toDoListService;


    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }


    @GetMapping
    public ResponseEntity<?> listAllToDos() {
        List<ToDoResponseModel> toDoResponseModels = toDoListService.listAllToDos();
        return new ResponseEntity<>(toDoResponseModels, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getToDoById(@PathVariable String id) {
        ToDoResponseModel toDoResponseModel = toDoListService.getToDoById(id);
        return new ResponseEntity<>(toDoResponseModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addToDo(@RequestBody ToDoAddRequestModel requestModel) {
        toDoListService.addToDo(requestModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateToDo(@RequestBody ToDoUpdateRequestModel requestModel) {
        toDoListService.updateToDo(requestModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteToDo(@PathVariable String id) {
        toDoListService.deleteToDo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
