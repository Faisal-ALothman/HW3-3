package com.example.schoolmanagment1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Teacher {
    @NotNull
    @Id
    private Integer id ;
    @NotEmpty
    private    String name ;
    @NotNull
    private Integer salary ;


}