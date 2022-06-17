package com.example.eva.controller.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseProductModel {
    private Long id;
    private String name;
    private String description;
}
