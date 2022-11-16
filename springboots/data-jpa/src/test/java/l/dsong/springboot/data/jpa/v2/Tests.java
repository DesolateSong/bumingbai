package l.dsong.springboot.data.jpa.v2;

import l.dsong.springboot.data.jpa.SimpleDataJPAApplication;
import l.dsong.springboot.data.jpa.v2.entity.*;
import l.dsong.springboot.data.jpa.v2.repository.ManyARepository;
import l.dsong.springboot.data.jpa.v2.repository.ManyBRepository;
import l.dsong.springboot.data.jpa.v2.service.ClasssService;
import l.dsong.springboot.data.jpa.v2.service.GradeService;
import l.dsong.springboot.data.jpa.v2.service.StudentService;
import l.dsong.springboot.data.jpa.v2.service.TreeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;

@SpringBootTest(classes = SimpleDataJPAApplication.class)
public class Tests {

    @Resource
    public ManyBRepository manyBRepository;
    @Resource
    private StudentService studentService;
    @Resource
    private ClasssService classsService;
    @Resource
    private GradeService gradeService;
    @Resource
    private TreeService treeService;
    @Resource
    private ManyARepository manyARepository;

    @Test
    public void studentSave() {
        Student stu = new Student();
        stu.setName("Tom");
        stu.setSex("1");
        stu.setHealthState("very strong");
        stu.setAge(8);
        stu.setBirthday(LocalDate.of(2014, 01, 01));
        stu.setHeight(1.32);
        stu.setWeight(56.0);
        studentService.save(stu);
        stu = new Student();
        stu.setName("Jack");
        stu.setSex("1");
        stu.setHealthState("very strong");
        stu.setAge(8);
        stu.setBirthday(LocalDate.of(2014, 01, 01));
        stu.setHeight(1.32);
        stu.setWeight(56.0);
        studentService.save(stu);
        stu = new Student();
        stu.setName("Alice");
        stu.setSex("1");
        stu.setHealthState("a little thin");
        stu.setAge(8);
        stu.setBirthday(LocalDate.of(2014, 01, 01));
        stu.setHeight(1.32);
        stu.setWeight(56.0);
        studentService.save(stu);

    }

    @Test
    @Transactional
    public void stuList() {
        studentService.list(new Student()).forEach(System.out::println);
    }

    @Test
    public void manyToOneTest() {
        Grade grade = new Grade();
        grade.setGradeName("二年级");
        grade.setGradeLevel("2");
        Classs cl1 = new Classs();
        cl1.setClassName("1班");
        Classs cl2 = new Classs();
        cl2.setClassName("2班");
        Classs cl3 = new Classs();
        cl3.setClassName("3班");

        grade.getClassList().add(cl1);
        grade.getClassList().add(cl2);
        grade.getClassList().add(cl3);
        gradeService.save(grade);
    }

    @Test
    @Transactional
    public void one2manyTest() {
        Grade grade = gradeService.get(1588436104447660032L);
        System.out.println(grade.getGradeName());
        System.out.println(grade.getClassList().size());
        grade.getClassList().forEach(System.out::println);
    }

    @Test
    public void many2oneTest() {
        Classs cl1 = new Classs();
        cl1.setClassName("4班");
        cl1.setGradeId(1588436104447660032L);
        classsService.save(cl1);
    }

    @Test
    public void treeSave() {
        Tree root = new Tree("root");
        Tree l1_0 = new Tree("lv1_0");
        Tree l1_1 = new Tree("lv1_1");
        Tree l1_2 = new Tree("lv1_2");
        Tree l2_3 = new Tree("lv2_3");
        Tree l3_0 = new Tree("lv3_0");
        Tree l3_1 = new Tree("lv3_1");
        Tree l3_2 = new Tree("lv3_2");

        root.getSubTree().add(l1_0);
        root.getSubTree().add(l1_1);
        root.getSubTree().add(l1_2);

        l1_0.getSubTree().add(l2_3);

        l2_3.getSubTree().add(l3_0);
        l2_3.getSubTree().add(l3_1);
        l2_3.getSubTree().add(l3_2);

        treeService.save(root);

    }

    @Test
    @Transactional
    public void treeGetTest() {
        Tree root = treeService.get(1588442742776795136L);
        a(root);

    }

    public void a(Tree root) {
        for (Tree tree : root.getSubTree()) {
            System.out.println(tree.getTreeName());
            if (tree.getSubTree().size() > 0)
                a(tree);
        }
    }

    @Test
    public void manyA() {
        ManyA a = new ManyA();
        ManyB b1 = new ManyB();
        b1.setB("b1");
        ManyB b2 = new ManyB();
        b2.setB("b2");

        a.getManyBList().add(b1);
        a.getManyBList().add(b2);

        manyARepository.save(a);

    }

    @Test
    public void manyA2() {
        ManyA a1 = new ManyA("A1");
        ManyA a2 = new ManyA("A2");
        ManyA a3 = new ManyA("A3");

        ManyB b1 = new ManyB("B1");
        ManyB b2 = new ManyB("B2");
        ManyB b3 = new ManyB("B3");
        ManyB b4 = new ManyB("B4");

        a1.getManyBList().add(b1);
        a1.getManyBList().add(b3);

        a2.getManyBList().add(b1);
        a2.getManyBList().add(b4);

        a3.getManyBList().add(b1);
        a3.getManyBList().add(b2);
        a3.getManyBList().add(b3);
        a3.getManyBList().add(b4);

        b1.getManyAList().add(a1);
        b2.getManyAList().add(a2);
        b2.getManyAList().add(a3);
        b3.getManyAList().add(a2);
        b3.getManyAList().add(a3);
        b4.getManyAList().add(a3);
        b4.getManyAList().add(a1);

        manyARepository.save(a1);
        manyARepository.save(a2);
        manyARepository.save(a3);


    }

}
