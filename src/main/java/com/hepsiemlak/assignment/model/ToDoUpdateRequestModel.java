package com.hepsiemlak.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDoUpdateRequestModel {

    private String id;

    private String description;

    private Date targetDate;

    private String title;

    private String category;

    private boolean completed;}
