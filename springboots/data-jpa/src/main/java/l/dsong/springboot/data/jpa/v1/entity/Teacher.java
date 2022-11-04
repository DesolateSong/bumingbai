package l.dsong.springboot.data.jpa.v1.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_teacher")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Teacher extends People {

    @Column(name = "subject" , columnDefinition = "varchar(20) default ''")
    private String subject;
    @Column(name = "position" , columnDefinition = "varchar(20) default ''")
    private String position;

}
