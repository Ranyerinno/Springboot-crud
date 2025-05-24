package com.jorge.curso.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jorge.curso.springboot.app.springboot_crud.entities.Product;
import com.jorge.curso.springboot.app.springboot_crud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product save(Product product) {

        return productRepository.save(product);

    }

    @Override
    @Transactional
    public Optional<Product> update(Long id, Product product) {

        Optional<Product> productDb = productRepository.findById(id);

        if(productDb.isPresent()){
            Product prod = productDb.orElseThrow();
            prod.setName(product.getName());
            prod.setDescription(product.getDescription());
            prod.setPrice(product.getPrice());
            prod.setSku(product.getSku());
            return Optional.of(productRepository.save(prod));
        }

        return productDb; 

    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        
        return productRepository.findById(id);
        
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {

        return (List<Product>) productRepository.findAll();

    }

    @Override
    @Transactional
    public Optional<Product> delete(Long id) {

        Optional<Product> productDb = productRepository.findById(id);

        productDb.ifPresent(prod -> {
            productRepository.delete(prod);
        });

        return productDb; 

    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsBySku(String sku) {
        return productRepository.existsBySku(sku);
    }



}
