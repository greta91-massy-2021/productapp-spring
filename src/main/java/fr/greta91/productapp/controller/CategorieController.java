package fr.greta91.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.greta91.productapp.model.Categorie;
import fr.greta91.productapp.model.Produit;
import fr.greta91.productapp.repos.CategorieRepository;
import fr.greta91.productapp.repos.ProduitRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(maxAge = 3600, origins = "http://localhost:3000")
@RestController
@RequestMapping("/categories")
public class CategorieController {
	@Autowired
	CategorieRepository catRepo;
	@GetMapping("")
	public List<Categorie> getCategories(){
		List<Categorie> list = catRepo.findAll();
//		List<String> list = new ArrayList<String>();
//		list.add("Produit 1");
//		list.add("Produit 2");
//		list.add("Produit 3");
//		list.add("Produit 4");
		return list;
	}
}
