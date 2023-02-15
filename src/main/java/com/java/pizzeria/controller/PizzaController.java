package com.java.pizzeria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.pizzeria.model.Pizza;
import com.java.pizzeria.repository.PizzaRepository;



@Controller
@RequestMapping("/pizze")  
public class PizzaController {
	@Autowired
	PizzaRepository pizzaRepository;
	
	@GetMapping
	public String index(@RequestParam(name="keyword", required= false) String keyword,  Model model) {
		//List<Pizza> elencoPizze= pizzaRepository.findByNomeLike("%ghe%"); ricerca in base alla stringa che inserisco come parametro di ricerca
		List<Pizza> elencoPizze;
		if(keyword!=null && !keyword.isEmpty()) {
			elencoPizze= pizzaRepository.findByNomeLike("%"+ keyword +"%");
		}else {
			elencoPizze= pizzaRepository.findAll();
		}
		model.addAttribute("elencoPizze" , elencoPizze);
		keyword="";
		return "indexPizze";
	}
	
	@GetMapping("{id}") //richieste get /pizze/{id}
	public String dettailsPizza(@PathVariable("id") Integer id, Model model) {
		Optional<Pizza> p= pizzaRepository.findById(id);
		if(p.isEmpty()) {
			return "redirect:/error";
		}
		model.addAttribute("pizza",p.get());
		return "dettaglioPizza";
	}
}
