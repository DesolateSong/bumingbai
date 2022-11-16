package l.dsong.springboot.data.jpa.v2.repository;

import l.dsong.springboot.data.jpa.v2.entity.ManyA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyARepository extends JpaRepository<ManyA, Long>, JpaSpecificationExecutor<ManyA> {

}
