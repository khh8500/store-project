package com.example.store.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductRepository {

    private final EntityManager em;

    public void updateById(Integer id, ProductRequest.UpdateDTO reqDTO){
        Query query = em.createNativeQuery("update product_tb set name=?, price=?, qty=? where id=?", Product.class);
        query.setParameter(1, reqDTO.getName());
        query.setParameter(2, reqDTO.getPrice());
        query.setParameter(3, reqDTO.getQty());
        query.setParameter(4, id);
        query.executeUpdate();
    }

    public void save(ProductRequest.SaveDTO reqDTO){
        Query query = em.createNativeQuery("insert into product_tb (name, price, qty, created_at) values (?,?,?, now())");
        query.setParameter(1, reqDTO.getName());
        query.setParameter(2, reqDTO.getPrice());
        query.setParameter(3, reqDTO.getQty());
        query.executeUpdate();
    }

    public Product findById(Integer id){
        Query query = em.createNativeQuery("select * from product_tb where id=?", Product.class);
        query.setParameter(1, id);
        return (Product) query.getSingleResult();
    }

    public List<Product> findAll(){
        Query query = em.createNativeQuery("select * from product_tb order by id desc", Product.class);
        return query.getResultList();
    }
}
