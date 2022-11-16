package l.dsong.springboot.data.jpa.v2.service;

import l.dsong.springboot.data.jpa.v2.entity.Classs;
import l.dsong.springboot.data.jpa.v2.repository.ClasssRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ClasssService {

    @Resource
    private ClasssRepository classsRepository;

    public Classs save(Classs classs){
        return classsRepository.save(classs);
    }

    public Classs get(Long id){
        return classsRepository.getReferenceById(id);
    }

}
