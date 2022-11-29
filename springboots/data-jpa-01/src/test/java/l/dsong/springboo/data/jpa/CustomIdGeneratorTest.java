package l.dsong.springboo.data.jpa;

import l.dsong.springboo.data.jpa.entity.Dog;
import l.dsong.springboo.data.jpa.service.DogService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = CustomIdGeneratorApplication.class)
public class CustomIdGeneratorTest {

    @Resource
    private DogService dogService;


    @Test
    public void saveTest(){
        Dog dog = new Dog();

        dog.setId("one");
        dog.setName("No.1");

        dogService.save(dog);
    }
    @Test
    public void saveTest2(){
        Dog dog = new Dog();

        dog.setName("No.1");

        dogService.save(dog);
    }

}
