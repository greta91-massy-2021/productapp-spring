package fr.greta91.productapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {
	@GetMapping("")
	public List<String> getProduits(){
		List<String> list = new ArrayList<String>();
		list.add("Produit 1");
		list.add("Produit 2");
		list.add("Produit 3");
		list.add("Produit 4");
		return list;
	}
}
