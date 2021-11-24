package com.example.CoffeeShop.dao;

import com.example.CoffeeShop.models.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SweetDAO extends JpaRepository<Sweet, Integer> {
    @Query(value = "select sweet.* from sweets" +
            "where ('' = :name = :name) and " +
            "where ('' = :price = :price) and" +
            "where ('' = :imageUrl or image_url = :imageUrl)", nativeQuery = true)
    List<Sweet> FindAllBy(String name, int price, String imageUrl);
}
