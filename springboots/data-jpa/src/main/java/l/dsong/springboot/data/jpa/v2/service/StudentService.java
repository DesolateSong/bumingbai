package l.dsong.springboot.data.jpa.v2.service;

import cn.hutool.core.util.StrUtil;
import l.dsong.springboot.data.jpa.v2.entity.Student;
import l.dsong.springboot.data.jpa.v2.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @Resource
    private StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student get(Long id) {
        return studentRepository.getReferenceById(id);
    }

    public List<Student> list(Student student) {
        return studentRepository.findAll(specification(student), Sort.by(Sort.Direction.DESC, "createTime"));
    }

    private static Specification<Student> specification(Student student) {
        return new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if (student != null) {
                    if (StrUtil.isNotEmpty(student.getName())) {
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("name"), "%" + student.getName() + "%"));
                    }
                }
                return predicate;
            }
        };
    }

}
