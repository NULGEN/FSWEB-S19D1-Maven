package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    @Query(value = "SELECT v.id, v.name, v.price, v.is_grown_on_tree FROM fsweb.vegetable v ORDER BY v.price DESC", nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value = "SELECT v.id, v.name, v.price, v.is_grown_on_tree FROM fsweb.vegetable v ORDER BY v.price ASC", nativeQuery = true)
    List<Vegetable> getByPriceAsc();

    @Query(value = "SELECT v FROM Vegetable v where v.name LIKE %:name%")
    List<Vegetable> searchByName(String name);


    Optional<Object> findAllById(long id);

}
