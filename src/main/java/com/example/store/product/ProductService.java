package com.example.store.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateById(Integer id, ProductRequest.UpdateDTO reqDTO){
        productRepository.updateById(id, reqDTO);
    }

    public ProductResponse.UpdateDTO findUpdateById(Integer id) {
        Product product = productRepository.findById(id);
        return new ProductResponse.UpdateDTO(product);
    }

    @Transactional
    public void save(ProductRequest.SaveDTO reqDTO){
        productRepository.save(reqDTO);
    }

    public ProductResponse.DetailDTO findById(Integer id){
        Product product = productRepository.findById(id);
        return new ProductResponse.DetailDTO(product);
    }

    public List<ProductResponse.ListDTO> findAll() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product ->
                new ProductResponse.ListDTO(product)).toList();
    }
}
