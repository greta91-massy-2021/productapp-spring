package fr.greta91.productapp.services;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.greta91.productapp.dtos.UserDTO;
import fr.greta91.productapp.exceptions.UserNotFoundException;
import fr.greta91.productapp.model.User;
import fr.greta91.productapp.repos.UserRepository;

@Service
@Transactional
public class AuthService {
	@Autowired
	UserRepository userRepo;

	@Transactional(readOnly = true)
	public UserDTO login(String username, String password) throws UserNotFoundException {
		System.out.println("username : "+ username);
		System.out.println("password : "+ password);
		User user = userRepo.findByUsername(username);
		if(null == user) throw new UserNotFoundException();
		
		boolean passwordCorrect = BCrypt.checkpw(password, user.getPassword());
		if(!passwordCorrect) throw new UserNotFoundException();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setNom(user.getNom());
		userDTO.setPrenom(user.getPrenom());
		userDTO.setUsername(user.getUsername());
		List<String> roles = user.getRoles().stream().map(r ->{
			return r.getLibelle();
		}).collect(Collectors.toList());
		userDTO.setRoles(roles);
		return userDTO ;
	}
}
