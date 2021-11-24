package com.example.CoffeeShop.dao;

import com.example.CoffeeShop.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkDAO extends JpaRepository<Drink, Integer> {
    @Query(value = "select drink.* from drinks" +
            "where ('' = :name = :name) and " +
            "where ('' = :price = :price) and" +
            "where ('' = :imageUrl or image_url = :imageUrl)", nativeQuery = true)
    List<Drink> FindAllBy(String name, int price, String imageUrl);
}
