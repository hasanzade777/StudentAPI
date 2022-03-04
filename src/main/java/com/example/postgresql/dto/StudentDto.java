package com.example.postgresql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDto {

    private String firstName;
    private String surname;
    private int age;
    private String address;
}
