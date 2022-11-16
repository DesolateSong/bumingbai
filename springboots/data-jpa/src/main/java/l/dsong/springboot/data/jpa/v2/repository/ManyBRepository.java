package l.dsong.springboot.data.jpa.v2.repository;

import l.dsong.springboot.data.jpa.v2.entity.ManyB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyBRepository extends JpaRepository<ManyB, Long> {
}
