package org.java.lessons.spring_la_mia_pizzeria_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.java.lessons.spring_la_mia_pizzeria_crud.repository.PizzaRepository;

import java.util.List;

import org.java.lessons.spring_la_mia_pizzeria_crud.model.Pizza;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class PizzeController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping("/pizze")
    private String index(Model model) {

        List<Pizza> pizzas = repository.findAll();

        model.addAttribute("pizzas", pizzas);
        return "index";

    }

    @GetMapping("/pizza/{id}")
    private String show(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("pizza", repository.findById(id).get());

        return "singlePizzaPage";

    }

}
