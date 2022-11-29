package l.dsong.springboo.data.jpa.service;

import l.dsong.springboo.data.jpa.entity.Dog;
import l.dsong.springboo.data.jpa.repsotories.DogJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class DogService {
    @Resource
    private DogJpaRepository dogJpaRepository;

    public Dog save(Dog dog){
        return dogJpaRepository.save(dog);
    }


}
