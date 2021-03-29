package fr.greta91.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.greta91.productapp.model.Produit;
import fr.greta91.productapp.repos.ProduitRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@CrossOrigin(maxAge = 3600, origins = "http://localhost:3000")
@RestController
@RequestMapping("/produits")
public class ProduitController {
	@Autowired
	ProduitRepository produitRepo;
	@GetMapping("")
	public List<Produit> getProduits(@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber, @RequestParam(value = "perPage", required = false, defaultValue = "10") int perPage){
		Pageable page = PageRequest.of(pageNumber, perPage);
		Page<Produit> pageProduit = produitRepo.findAll(page);
//		List<String> list = new ArrayList<String>();
//		list.add("Produit 1");
//		list.add("Produit 2");
//		list.add("Produit 3");
//		list.add("Produit 4");
		return pageProduit.getContent();
	}
	
	@GetMapping("/count")
	public HashMap<String, Integer> getProduitsCount() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("produitsCount", produitRepo.getProduitsCount());
		return map;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produit> getProduit(@PathVariable int id) {
		Optional<Produit> optional = produitRepo.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
		try {
			Produit newProduit = produitRepo.save(produit);
			return ResponseEntity.ok(newProduit);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/edit")
	public ResponseEntity<Produit> editProduit(@RequestBody Produit produit) {
		try {
			Produit newProduit = produitRepo.save(produit);
			return ResponseEntity.ok(newProduit);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteProduit(@PathVariable("id") int produitId) {
		try {
			produitRepo.deleteById(produitId);
			return ResponseEntity.ok("OK");
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
