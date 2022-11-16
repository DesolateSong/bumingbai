package l.dsong.springboot.data.jpa.v2.entity;

import l.dsong.springboot.data.jpa.v1.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Entity
@Table(name = "t_class")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Classs extends BaseEntity {

    @Column(name = "class_name", columnDefinition = "varchar(10)")
    private String className;

    @Column(name = "grade_id")
    private Long gradeId;


}
