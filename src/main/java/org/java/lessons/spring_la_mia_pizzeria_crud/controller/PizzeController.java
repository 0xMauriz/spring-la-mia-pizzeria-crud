package org.java.lessons.spring_la_mia_pizzeria_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.java.lessons.spring_la_mia_pizzeria_crud.repository.PizzaRepository;

import java.util.List;

import org.java.lessons.spring_la_mia_pizzeria_crud.model.Pizza;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/pizze")
public class PizzeController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    private String index(Model model) {

        List<Pizza> pizzas = repository.findAll();

        model.addAttribute("pizzas", pizzas);
        return "index";

    }

    @GetMapping("/{id}")
    private String show(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("pizza", repository.findById(id).get());

        return "singlePizzaPage";

    }

    @GetMapping("/create-new")
    private String create(Model model) {
        model.addAttribute("pizza", new Pizza());

        return "createNewPizzaPage";
    }

    @PostMapping("/create-new")
    private String store(@Valid @ModelAttribute("pizza") Pizza newPizza, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "createNewPizzaPage";
        }

        repository.save(newPizza);

        return "redirect:/pizze";
    }

    @GetMapping("/edit/{id}")
    private String edit(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("pizza", repository.findById(id).get());

        return "editPage";

    }

    @PostMapping("/edit/{id}")
    private String update(@Valid @ModelAttribute("pizza") Pizza editedPizza, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editPage";
        }

        repository.save(editedPizza);

        return "redirect:/pizze";
    }

    @PostMapping("/delete/{id}")
    private String delete(@PathVariable Integer id) {

        repository.deleteById(id);

        return "redirect:/pizze";
    }

}
