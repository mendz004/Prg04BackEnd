package br.com.ifba.prg04backend.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationException {

    private String title;
    private int status;
    private String details;
    private String fields;
    private String fieldMessages;

}
