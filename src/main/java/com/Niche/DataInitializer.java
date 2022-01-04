//package com.Niche;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.Niche.model.User;
//import com.Niche.repository.UserRepository;
//
//@Component
//public class DataInitializer implements ApplicationRunner {
//	private UserRepository userRepository;
//	private PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//		this.userRepository = userRepository;
//		this.passwordEncoder = passwordEncoder;
//	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		User josh = new User("josh", this.passwordEncoder.encode("josh"));
//		josh.addUserAuthority("READ");
//		User mulie = new User("mulie", this.passwordEncoder.encode("mulie"));
//		mulie.addUserAuthority("READ");
//		mulie.addUserAuthority("WRITE");
//		this.userRepository.save(josh);
//		this.userRepository.save(mulie);
//	}
//
//}
