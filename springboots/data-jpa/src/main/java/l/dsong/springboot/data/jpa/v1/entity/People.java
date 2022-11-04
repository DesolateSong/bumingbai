package l.dsong.springboot.data.jpa.v1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.time.LocalDate;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class People extends BaseEntity {

    @Column(name = "name", columnDefinition = "varchar(10) not null")
    private String name;
    @Column(name = "sex", columnDefinition = "varchar(1) not null")
    private String sex;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "age", columnDefinition = "integer(3)")
    private Integer age;
    @Column(name = "weight", columnDefinition = "float(5,2)")
    private Double weight;
    @Column(name = "height", columnDefinition = "float(3,2)")
    private Double height;


    @Transient
    private Integer pageSize = 10;
    @Transient
    private Integer pageNo = 0;

}
