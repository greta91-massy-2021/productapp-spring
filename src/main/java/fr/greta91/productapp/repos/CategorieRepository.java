package fr.greta91.productapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.greta91.productapp.model.Categorie;

public interface CategorieRepository 
			extends JpaRepository<Categorie, Integer> {

}
