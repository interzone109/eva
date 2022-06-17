package com.example.eva.service.impl;

import com.example.eva.controller.model.ResponseProductModel;
import com.example.eva.repository.ProductRepository;
import com.example.eva.repository.entity.ProductEntity;
import com.example.eva.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;


    @Override
    public List<ResponseProductModel> nameFilter(String regex) {
        LinkedList<ProductEntity> linkedList =  new LinkedList<>(productRepository.findAll());
        var iter = linkedList.listIterator();
        Pattern pattern = Pattern.compile(regex);

        while (iter.hasNext()){
            var product = iter.next();
            if( pattern.matcher( product.getName()).find()){
                iter.remove();
            }
        }
            return linkedList.stream().map(entity->ResponseProductModel.builder().build()).collect( Collectors.toList());
    }
}
