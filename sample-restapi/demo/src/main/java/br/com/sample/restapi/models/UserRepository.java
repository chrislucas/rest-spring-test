package br.com.sample.restapi.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Modifying
	@Query("UPDATE User u set u.name=:name, u.document=:document, u.emailAddress=:email_address WHERE u.id=:id")
	void updateById(@Param("id") long id
			, @Param("name") String name
			, @Param("document") String document
			, @Param("email_address") String emailAddress);
	
}
