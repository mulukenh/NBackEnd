package com.Niche.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Niche.model.Token;
import com.Niche.model.User;
import com.Niche.security.UserRepositoryUserDetailsService;
import com.Niche.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepositoryUserDetailsService userRepositoryUserDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public  ResponseEntity<?> getAuthenticationToken(@Valid @RequestBody User user) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Wrong username or password", e);
		}
		UserDetails userDetails = userRepositoryUserDetailsService.loadUserByUsername(user.getUsername());
		String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new Token(jwt));
	}
}
