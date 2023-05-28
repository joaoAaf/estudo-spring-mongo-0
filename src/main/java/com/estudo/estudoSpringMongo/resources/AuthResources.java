package com.estudo.estudoSpringMongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.estudoSpringMongo.domain.Admin;
import com.estudo.estudoSpringMongo.dto.Login;
import com.estudo.estudoSpringMongo.services.TokenService;

@CrossOrigin
@RestController
public class AuthResources {

	@Autowired
	private AuthenticationManager authM;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public String login(@RequestBody Login login) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(login.login(), login.pass());
		
		Authentication auth = this.authM.authenticate(authToken);
		
		var admin = (Admin) auth.getPrincipal();
		
		return tokenService.gerarToken(admin);
	}
	
}
