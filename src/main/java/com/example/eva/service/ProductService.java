package com.example.eva.service;

import com.example.eva.controller.model.ResponseProductModel;

import java.util.List;

public interface ProductService {
    List<ResponseProductModel> nameFilter(String regex);
}
