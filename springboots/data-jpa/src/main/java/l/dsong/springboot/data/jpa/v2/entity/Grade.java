package l.dsong.springboot.data.jpa.v2.entity;

import l.dsong.springboot.data.jpa.v1.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="t_grade")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Grade extends BaseEntity {
    @Column(name = "grade_name", columnDefinition = "varchar(10)")
    private String gradeName;
    @Column(name="grade_level", columnDefinition = "varchar(10)")
    private String gradeLevel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<Classs> classList = new ArrayList<>();

    public Grade() {
    }

    public Grade(Long id) {
        super(id);
    }
}
