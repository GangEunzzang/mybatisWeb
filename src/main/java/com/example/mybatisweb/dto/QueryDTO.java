package com.example.mybatisweb.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.REGON;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class QueryDTO {

    @NotBlank
    private String query;
}
