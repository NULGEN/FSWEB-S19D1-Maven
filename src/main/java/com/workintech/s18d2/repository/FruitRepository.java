package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FruitRepository extends JpaRepository <Fruit, Long> {

    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM fsweb.fruit f ORDER BY f.price DESC", nativeQuery = true)
    List<Fruit> getByPriceDesc();

    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM fsweb.fruit f ORDER BY f.price ASC", nativeQuery = true)
    List<Fruit> getByPriceAsc();

    @Query(value = "SELECT f FROM Fruit f where f.name LIKE %:name%")
    List<Fruit> searchByName(String name);


    Optional<Object> findAllById(long id);
}
