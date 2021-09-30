package com.hepsiemlak.assignment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hepsiemlak.assignment.controller.ToDoListController;
import com.hepsiemlak.assignment.model.ToDoAddRequestModel;
import com.hepsiemlak.assignment.model.ToDoResponseModel;
import com.hepsiemlak.assignment.service.ToDoListService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;
import java.util.UUID;


import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ToDoListController.class)
public class ToDoListControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ToDoListService toDoListService;

    @Test
    public void getAllTodosTest() throws Exception {

        ToDoResponseModel toDoResponseModel = ToDoResponseModel.builder()
                .description("test")
                .targetDate(new Date())
                .build();

        List<ToDoResponseModel> allTodos = singletonList(toDoResponseModel);
        given(toDoListService.listAllToDos()).willReturn(allTodos);

        mvc.perform(get("/api/todolist")).andExpect(status().isOk());

    }

    @Test
    public void getTodoByIdTest() throws Exception {
        ToDoResponseModel toDoResponseModel = ToDoResponseModel.builder()
                .id(UUID.randomUUID().toString())
                .description("test")
                .targetDate(new Date())
                .build();

        given(toDoListService.getToDoById(String.valueOf(toDoResponseModel.getId()))).willReturn(toDoResponseModel);

        mvc.perform(get("/api/todolist").pathInfo("/" + toDoResponseModel.getId()))
                .andExpect(status()
                        .isOk());

    }


    @Test
    public void addTodoByIdTest() throws Exception {

        ToDoAddRequestModel toDoRequestModel = ToDoAddRequestModel.builder()
                .description("test")
                .targetDate(new Date())
                .build();


        mvc.perform(post("/api/todolist")
                .content(asJsonString(toDoRequestModel))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    public void updateTodoByIdTest() throws Exception {

        ToDoAddRequestModel toDoRequestModel = ToDoAddRequestModel.builder()
                .description("test")
                .targetDate(new Date())
                .build();


        mvc.perform(put("/api/todolist")
                .content(asJsonString(toDoRequestModel))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    public void deleteTodoByIdTest() throws Exception {

        ToDoResponseModel toDoResponseModel = ToDoResponseModel.builder()
                .id(UUID.randomUUID().toString())
                .description("test")
                .targetDate(new Date())
                .build();


        mvc.perform(delete("/api/todolist/" + toDoResponseModel.getId()))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
