package com.example.schoolmanagment1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Student {
    @NotNull
    @Id
    private Integer id ;
    @NotEmpty
    private    String name ;
    @NotNull
    private Integer age ;

    @NotEmpty
    @Column(columnDefinition = "varchar(30) check(major='CS'or major='math' or major='Engineer')")
    private String major;


}