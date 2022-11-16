package l.dsong.springboot.data.jpa.v2.repository;

import l.dsong.springboot.data.jpa.v2.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> , JpaSpecificationExecutor<Tree> {
}
