package l.dsong.springboo.data.jpa.entity;

import l.dsong.springboo.data.jpa.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "t_dog")
public class Dog extends BaseEntity {

    @Column(name = "name")
    private String name;
}
