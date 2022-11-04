package l.dsong.springboot.data.jpa.v1.service;

import cn.hutool.core.util.StrUtil;
import l.dsong.springboot.data.jpa.v1.entity.Teacher;
import l.dsong.springboot.data.jpa.v1.repository.TeacherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
public class TeacherService {

    @Resource
    private TeacherRepository teacherRepository;

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    public Teacher get(Long id) {
        return teacherRepository.getReferenceById(id);
    }

    private Specification<Teacher> specification(Teacher teacher) {
        return new Specification<>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (teacher != null) {
                    if (null != teacher.getStartDate() && null != teacher.getEndDate()) {
                        predicate.getExpressions().add(cb.between(root.get("createTime"), teacher.getStartDate(), teacher.getEndDate()));
                    } else if (teacher.getStartDate() != null) {
                        predicate.getExpressions().add(cb.greaterThan(root.get("createTime"), teacher.getStartDate()));
                    } else if (teacher.getEndDate() != null) {
                        predicate.getExpressions().add(cb.lessThan(root.get("createTime"), teacher.getEndDate()));
                    }

                    if (StrUtil.isNotEmpty(teacher.getName())) {
                        predicate.getExpressions().add(cb.equal(root.get("name"), teacher.getName()));
                    }

                }
                return predicate;
            }
        };
    }

    public Page<Teacher> page(Teacher teacher) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        return teacherRepository.findAll(specification(teacher), PageRequest.of(teacher.getPageNo(), teacher.getPageSize(), sort));
    }

    public List<Teacher> list(Teacher teacher) {
        return teacherRepository.findAll(specification(teacher));
    }

}
