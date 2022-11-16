package l.dsong.springboot.data.jpa.v2.repository;

import l.dsong.springboot.data.jpa.v2.entity.Classs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClasssRepository extends JpaRepository<Classs, Long>, JpaSpecificationExecutor<Classs> {
}
