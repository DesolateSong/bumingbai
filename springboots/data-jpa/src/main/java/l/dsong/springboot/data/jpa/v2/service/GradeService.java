package l.dsong.springboot.data.jpa.v2.service;

import l.dsong.springboot.data.jpa.v2.entity.Grade;
import l.dsong.springboot.data.jpa.v2.repository.GradeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class GradeService {

    @Resource
    private GradeRepository gradeRepository;

    public Grade save(Grade grade){
        return gradeRepository.save(grade);
    }

    public Grade get(Long id){
        return gradeRepository.getReferenceById(id);
    }

}
