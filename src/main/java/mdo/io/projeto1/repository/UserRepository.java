package mdo.io.projeto1.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import mdo.io.projeto1.entity.User;

public interface UserRepository extends MongoRepository <User, Long>{
	
	User findByName(String name);
	
	User findByEmail(String email);
	
	User findByNameIgnoreCase(String name);	
	
	@Query("{'email': ?0 }")
	User findByEmailQualquerCoisa(String email);
}
