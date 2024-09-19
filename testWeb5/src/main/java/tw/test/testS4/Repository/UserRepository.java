package tw.test.testS4.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tw.test.testS4.Model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	public List<User> findByAccount(String account);
	public List<User> findByAccountContaining(String account);
	
	@Query("select u from User u where u.account like %:account% or u.name like %:name%")
	public List<User> findByAccountOrNameLike(@Param("account") String account,@Param("name") String name);
	
}
