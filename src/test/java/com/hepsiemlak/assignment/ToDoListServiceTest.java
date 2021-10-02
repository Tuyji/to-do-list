package com.hepsiemlak.assignment;


import com.hepsiemlak.assignment.entity.ToDo;
import com.hepsiemlak.assignment.model.ToDoAddRequestModel;
import com.hepsiemlak.assignment.model.ToDoResponseModel;
import com.hepsiemlak.assignment.model.ToDoUpdateRequestModel;
import com.hepsiemlak.assignment.repository.ToDoRepository;
import com.hepsiemlak.assignment.service.ToDoListService;
import com.hepsiemlak.assignment.service.impl.ToDoListServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ToDoListServiceTest {

    @Mock
    ToDoRepository toDoRepository;

    @InjectMocks
    ToDoListServiceImpl toDoListService;


    @Test
    public void getAllTodosServiceTest() {
        ToDo todo = ToDo.builder()
                .id("47f5da72-54d3-42ae-ab05-18cab12b7409")
                .category("event")
                .title("ToDoTask")
                .description("test")
                .completed(true)
                .targetDate(new Date())
                .build();

        List<ToDo> toDos = singletonList(todo);

        when(toDoRepository.findAll()).thenReturn(toDos);

        List<ToDoResponseModel> toDoResponseModels = toDoListService.listAllToDos();

        assertEquals(toDos.size(), toDoResponseModels.size());
        assertEquals(toDos.get(0).getDescription(), toDoResponseModels.get(0).getDescription());

    }

    @Test
    public void getToDoByIdServiceTest() {
        ToDo todo = ToDo.builder()
                .id("47f5da72-54d3-42ae-ab05-18cab12b7409")
                .category("event")
                .title("ToDoTask")
                .description("test")
                .completed(true)
                .description("test")
                .targetDate(new Date())
                .build();

        when(toDoRepository.findById(todo.getId())).thenReturn(Optional.of(todo));

        ToDoResponseModel toDoResponseModel = toDoListService.getToDoById(todo.getId());

        assertEquals(toDoResponseModel.getId(), todo.getId());
        assertEquals(toDoResponseModel.getDescription(), todo.getDescription());
        assertEquals(toDoResponseModel.getTargetDate(), todo.getTargetDate());
    }

    @Test
    public void addToDoServiceTest() {
        ToDo todo = ToDo.builder()
                .id("47f5da72-54d3-42ae-ab05-18cab12b7409")
                .category("event")
                .title("ToDoTask")
                .description("test")
                .completed(true)
                .targetDate(new Date())
                .build();

        when(toDoRepository.save(any(ToDo.class))).thenReturn(todo);

        ToDoAddRequestModel toDoAddRequestModel = ToDoAddRequestModel.builder().build();

        BeanUtils.copyProperties(todo, toDoAddRequestModel);

        ToDo toDoEntity = toDoListService.addToDo(toDoAddRequestModel);

        assertEquals(toDoEntity.getId(), todo.getId());
        assertEquals(toDoEntity.getDescription(), todo.getDescription());
        assertEquals(toDoEntity.getTargetDate(), todo.getTargetDate());
    }

    @Test
    public void updateToDoServiceTest() {

        ToDo todo = ToDo.builder()
                .id("47f5da72-54d3-42ae-ab05-18cab12b7409")
                .category("event")
                .title("ToDoTask")
                .description("test")
                .completed(true)
                .targetDate(new Date())
                .build();

        ToDo newToDo = ToDo.builder()
                .id("47f5da72-54d3-42ae-ab05-18cab12b7409")
                .category("event")
                .title("ToDoTask")
                .completed(true)
                .targetDate(new Date())
                .description("test-update")
                .build();

        ToDoUpdateRequestModel toDoUpdateRequestModel = ToDoUpdateRequestModel.builder().build();

        BeanUtils.copyProperties(newToDo, toDoUpdateRequestModel);

        given(toDoRepository.findById(todo.getId())).willReturn(Optional.of(todo));
        toDoListService.updateToDo(toDoUpdateRequestModel);
        verify(toDoRepository).save(newToDo);
        verify(toDoRepository).findById(todo.getId());
    }

    @Test
    public void deleteToDoServiceTest() {
        ToDo todo = ToDo.builder()
                .id("47f5da72-54d3-42ae-ab05-18cab12b7409")
                .category("event")
                .title("ToDoTask")
                .description("test")
                .completed(true)
                .targetDate(new Date())
                .build();


        when(toDoRepository.findById(todo.getId())).thenReturn(Optional.of(todo));
        toDoListService.deleteToDo(todo.getId());
        verify(toDoRepository).deleteById(todo.getId());
    }



}
