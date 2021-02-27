package com.example.demo.service;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product getProductById(Long id) {
        try {
            Product product = productMapper.selectProductById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return productMapper.selectProductById(id);
    }

    public List<Product> getAllProducts() {

        return productMapper.selectAllProducts();
    }

    @Transactional
    public void addProduct(Product product) {

        productMapper.insertProduct(product);
    }
}
