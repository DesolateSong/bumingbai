package l.dsong.springboot.data.jpa.v1;

import l.dsong.springboot.data.jpa.SimpleDataJPAApplication;
import l.dsong.springboot.data.jpa.v1.entity.Teacher;
import l.dsong.springboot.data.jpa.v1.repository.TeacherRepository;
import l.dsong.springboot.data.jpa.v1.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = SimpleDataJPAApplication.class)
public class Tests {

    @Resource
    private TeacherService teacherService;

    @Test
    public void save() {

        Teacher teacher = new Teacher();
        teacher.setName("张老师");
        teacher.setSex("0");
        teacher.setAge(30);
        teacher.setBirthday(LocalDate.of(1992, 01, 01));
        teacher.setHeight(1.78);
        teacher.setWeight(200.3);
        teacher = teacherService.save(teacher);
        System.out.println(teacher.getId());

    }

    @Test
    @Transactional
    public void getById() {
        Teacher teacher = teacherService.get(1588140566129020928L);
        System.out.println(teacher);
    }

    @Test
//    @Transactional
    public void findTest1() {
        Teacher q = new Teacher();
        q.setName("张老师");
//        q.setStartDate(LocalDate.now().atTime(LocalTime.MIN));
//        q.setEndDate(LocalDate.now().atTime(LocalTime.MAX));
        System.out.println(q);
        Page<Teacher> page = teacherService.page(q);
        System.out.println(page.getTotalPages());
        System.out.println(page.getTotalElements());
        System.out.println(page.getNumberOfElements());
        page.getContent().forEach(System.out::println);
    }

    @Test
    public void listTest1() {
        Teacher condition = new Teacher();
        condition.setName("张老师");
        List<Teacher> ls = teacherService.list(condition);
        ls.forEach(System.out::println);
    }


    @Test
    public void idTest(){

        Teacher condition = new Teacher();
        condition.setId(1L);
        condition.setName("IDBe1L");
        condition.setSex("1");
        teacherService.save(condition);


    }

    @Resource
    private TeacherRepository teacherRepository;

    @Test
    public void pageTest1(){
        Teacher condi = new Teacher();
        condi.setName("张老师");

        Page<Teacher> page = teacherRepository.findAll(
                (Specification<Teacher>)     (root, query, cb)->{
                    return cb.equal(root.get("name"), condi.getName());
                }   ,
                PageRequest.of(0,2, Sort.unsorted())
        );

        System.out.println(page.getTotalElements());
        System.out.println(page.getNumber());
        System.out.println(page.getTotalPages());
        page.getContent().forEach(System.out::println);

    }

    @Test
    public void pageTest2(){
        Teacher te = new Teacher();
        Page<Teacher> page = teacherRepository.findAll(
                (Specification<Teacher>) (root, query, cb)->{
                    return cb.conjunction();
                },
                PageRequest.of(0, 1, Sort.by("createTime"))
        );

        System.out.println(page.getTotalPages());
        page.getContent().forEach(System.out::println);
    }

}
