package com.java.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.pizzeria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
