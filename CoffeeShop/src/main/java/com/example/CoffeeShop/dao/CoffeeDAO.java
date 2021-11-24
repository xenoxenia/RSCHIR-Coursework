package com.example.CoffeeShop.dao;

import com.example.CoffeeShop.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeDAO extends JpaRepository<Coffee, Integer> {
    @Query(value = "select coffee.* from coffee" +
            "where ('' = :name = :name) and " +
            "where ('' = :price = :price) and" +
            "where ('' = :imageUrl or image_url = :imageUrl)", nativeQuery = true)
    List<Coffee> FindAllBy(String name, int price, String imageUrl);
}
