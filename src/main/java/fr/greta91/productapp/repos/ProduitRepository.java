package fr.greta91.productapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.greta91.productapp.model.Produit;

public interface ProduitRepository 
			extends JpaRepository<Produit, Integer> {

}
