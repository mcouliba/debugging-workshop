package com.redhat.cloudnative.catalog;

import java.util.*;
import java.util.stream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/catalog")
public class CatalogController {
    @Autowired
    private ProductRepository repository;

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll() {
        Spliterator<Product> products = repository.findAll().spliterator();
        Random random = new Random();
    
        List<Product> result = new ArrayList<Product>();
        products.forEachRemaining(product -> {
            Class<Product> clazz = Product.class;
            if (clazz.isInstance(product)){
                try {
                    Thread.sleep(random.nextInt(10) * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            result.add(product);
        });
        return result;
    }
}