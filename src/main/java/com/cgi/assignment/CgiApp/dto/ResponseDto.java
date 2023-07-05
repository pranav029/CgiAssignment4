package com.cgi.assignment.CgiApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
    private String message;
    private boolean success;
    private T data;
    private String error;
}
