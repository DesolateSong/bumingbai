package l.dsong.springboot.data.jpa.v2.repository;

import l.dsong.springboot.data.jpa.v2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {


}
