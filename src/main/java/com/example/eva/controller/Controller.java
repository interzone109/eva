package com.example.eva.controller;

import com.example.eva.controller.model.ResponseProductModel;
import com.example.eva.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/shop")
@AllArgsConstructor
public class Controller {

    private ProductService productService;

    @GetMapping("/product")
    public List<ResponseProductModel> nameFilter(@PathVariable String regex) {
        return productService.nameFilter(regex);
    }
}
