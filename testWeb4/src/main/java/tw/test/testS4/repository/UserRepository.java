package tw.test.testS4.repository;

import org.springframework.data.repository.CrudRepository;

import tw.test.testS4.model.UserV2;

/*
 * fundamental => CrudRepository
 * Paging version => PagingAndSortRepository
 * ex-version => JpaRepository
 * --------------------------------------------
 * save() => add data
 * saveAll() => (List,Set,Map,[])
 * 
 * deleteById() => delete by id
 * delete(object) => delete by object
 * 
 * findById() => search
 * existsById() => true/false
 * 
 * count() => return find out data count
 * 
 * */
public interface UserRepository extends CrudRepository<UserV2,Long>{

	
	
}
