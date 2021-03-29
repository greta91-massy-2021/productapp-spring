package fr.greta91.productapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.greta91.productapp.model.Produit;

public interface ProduitRepository 
			extends JpaRepository<Produit, Integer> {
	@Query("SELECT COUNT(p.id) from Produit p")
    int getProduitsCount();
}
