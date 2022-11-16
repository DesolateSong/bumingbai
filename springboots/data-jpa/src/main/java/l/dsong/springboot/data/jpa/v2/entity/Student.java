package l.dsong.springboot.data.jpa.v2.entity;

import l.dsong.springboot.data.jpa.v1.entity.People;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="t_student")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Student extends People {

    @Column(name = "health_state", columnDefinition = "varchar(64)")
    private String healthState;

}
