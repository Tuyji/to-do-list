package com.hepsiemlak.assignment.service.impl;

import com.hepsiemlak.assignment.entity.ToDo;
import com.hepsiemlak.assignment.exception.ToDoNotFoundException;
import com.hepsiemlak.assignment.model.ToDoAddRequestModel;
import com.hepsiemlak.assignment.model.ToDoResponseModel;
import com.hepsiemlak.assignment.model.ToDoUpdateRequestModel;
import com.hepsiemlak.assignment.repository.ToDoRepository;
import com.hepsiemlak.assignment.service.ToDoListService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoListServiceImpl implements ToDoListService {

    private final ToDoRepository repository;

    public ToDoListServiceImpl(ToDoRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<ToDoResponseModel> listAllToDos() {
        List<ToDoResponseModel> toDoResponseModels = new ArrayList<>();
        repository.findAll().forEach(t -> toDoResponseModels.add(createResponseModel(t)));
        return toDoResponseModels;
    }

    private ToDoResponseModel createResponseModel(ToDo toDo) {
        ToDoResponseModel responseModel = ToDoResponseModel.builder().build();
        BeanUtils.copyProperties(toDo, responseModel);
        return responseModel;
    }

    @Override
    public ToDoResponseModel getToDoById(String id) {
        ToDo toDo = repository.findById(id).orElseThrow(() -> new ToDoNotFoundException(id));
        ToDoResponseModel responseModel = ToDoResponseModel.builder().build();
        BeanUtils.copyProperties(toDo, responseModel);
        return responseModel;
    }

    @Override
    public void addToDo(ToDoAddRequestModel requestModel) {
        ToDo toDo = ToDo.builder().build();
        BeanUtils.copyProperties(requestModel, toDo);
        repository.save(toDo);
    }

    @Override
    public void updateToDo(ToDoUpdateRequestModel requestModel) {
        String id = requestModel.getId();
        ToDo toDo = repository.findById(id).orElseThrow(() -> new ToDoNotFoundException(id));
        BeanUtils.copyProperties(requestModel, toDo);
        repository.save(toDo);
    }

    @Override
    public void deleteToDo(String id) {
        repository.deleteById(id);
    }
}
