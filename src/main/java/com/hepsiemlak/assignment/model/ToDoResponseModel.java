package com.hepsiemlak.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDoResponseModel {

    @JsonIgnore
    private String id;

    private String description;

    private Date targetDate;
}
