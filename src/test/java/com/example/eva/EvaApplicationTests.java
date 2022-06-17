package com.example.eva;

import com.example.eva.controller.Controller;
import com.example.eva.repository.ProductRepository;
import com.example.eva.repository.entity.ProductEntity;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EvaApplicationTests {
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private Controller controller;

    @BeforeEach
    public void setup() {
        List<ProductEntity> list = generate();
        Mockito.when(productRepository.findAll()).thenReturn(list);
    }

    private List<ProductEntity> generate() {
        List<ProductEntity> list = new ArrayList<>();
        list.add(new ProductEntity(1l, "test", "test"));
        list.add(new ProductEntity(2l, "test", "test"));
        list.add(new ProductEntity(3l, "test", "test"));
        return list;
    }

    @Test
    void didntFindName() {
       var result =  controller.nameFilter("test");
        Assertions.assertEquals(0 , result.size());
    }
    @Test
    void findName() {
        var result =  controller.nameFilter("eva");
        Assertions.assertEquals(3 , result.size());
    }
}
