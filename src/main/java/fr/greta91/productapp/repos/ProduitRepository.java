package fr.greta91.productapp.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.greta91.productapp.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
	
	@Query("SELECT COUNT(p.id) from Produit p")
    int getProduitsCount();
	
	List<Produit> findAllByNomContainingIgnoreCase(String searchWord, Pageable page);
	

	@Query("SELECT COUNT(p.id) from Produit p where p.nom LIKE %?1%")
    int getProduitsCountByNom(String searchWord);
}
