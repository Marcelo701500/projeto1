package mdo.io.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import mdo.io.projeto1.entity.User;
import mdo.io.projeto1.repository.UserRepository;

@Component
public class DataInitialzr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			
			//User user = new User();
			
			//user.setEmail("marcelo701503@gmail.com");
			//user.setName("Marcelo Oliveira");		
			
			//userRepository.save(user);
			
			System.out.println("Entrou aqui para adicionar ...");
			
			createUser("Marcelo", "marcelo701503@gmail.com");
			createUser("Marcos", "marcos@gmail.com");
			createUser("Arthur", "arthur@gmail.com");
			
		}
		
		User user = userRepository.findByName("Arthur");
		System.out.println("Busca por nome: " + user.getId() + " " + user.getName() + " " + user.getEmail());
		
		User userEmail = userRepository.findByEmail("marcos@gmail.com");
		System.out.println("Busca por email: " + userEmail.getId() + " " + userEmail.getName());
			
		//User userIgnoreCase = userRepository.findByNameIgnoreCase("marce");
		//System.out.println("Busca Ignone Case: " + userIgnoreCase.getName());		
		
		User userQuery = userRepository.findByEmailQualquerCoisa("marcelo701503@gmail.com");
		System.out.println("Busca por Query: " + userQuery.getName());		
		
		//User user = userRepository.getOne(2L);
		//System.out.println(user.getId() + " " + user.getName() + " " + user.getEmail());
		
		//userRepository.deleteById(2L);
		//System.out.println("Registro deletado com sucesso !");
		
		//User userNome = userRepository.getOne(1L);
		//userNome.setName("Marcelo");
		//userRepository.save(userNome);	
		
	}
	
	public void createUser(String name, String email) {
		
		User user = new User(name, email);
		
		userRepository.save(user);
		
	}
}
