package com.hepsiemlak.assignment.service;

import com.hepsiemlak.assignment.entity.ToDo;
import com.hepsiemlak.assignment.model.ToDoAddRequestModel;
import com.hepsiemlak.assignment.model.ToDoResponseModel;
import com.hepsiemlak.assignment.model.ToDoUpdateRequestModel;

import java.util.List;

public interface ToDoListService {

    List<ToDoResponseModel> listAllToDos();

    ToDoResponseModel getToDoById(String id);

    ToDo addToDo(ToDoAddRequestModel requestModel);

    ToDo updateToDo(ToDoUpdateRequestModel requestModel);

    void deleteToDo(String id);
}
