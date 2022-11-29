package l.dsong.springboo.data.jpa.repsotories;

import l.dsong.springboo.data.jpa.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DogJpaRepository extends JpaRepository<Dog, String> , JpaSpecificationExecutor<Dog> {

}
