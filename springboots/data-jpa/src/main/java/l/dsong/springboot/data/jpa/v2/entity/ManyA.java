package l.dsong.springboot.data.jpa.v2.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.ConstraintMode.NO_CONSTRAINT;

@Data
@Entity
@Table(name = "t_many_a")
@EntityListeners(AuditingEntityListener.class)
public class ManyA implements java.io.Serializable {
    @Id
    @CreatedBy
    @Column(name = "id")
    private Long id;
    @Column(name = "a")
    private String a;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "many_a_b",
            joinColumns = {@JoinColumn(name = "a_id", referencedColumnName = "id", foreignKey = @ForeignKey(NO_CONSTRAINT))},
            inverseJoinColumns = {@JoinColumn(name = "b_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none"))}
    )
    private List<ManyB> manyBList = new ArrayList<>();

    public ManyA() {
    }

    public ManyA(String a) {
        this.a = a;
    }
}
