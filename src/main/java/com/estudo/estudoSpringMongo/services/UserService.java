package com.estudo.estudoSpringMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.estudoSpringMongo.domain.User;
import com.estudo.estudoSpringMongo.dto.UserDTO;
import com.estudo.estudoSpringMongo.repository.UserRepository;
import com.estudo.estudoSpringMongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public void delete (String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO (UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
}
