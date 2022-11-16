package l.dsong.springboot.data.jpa.v2.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "t_many_b")
@EntityListeners(AuditingEntityListener.class)
public class ManyB {
    @Id
    @CreatedBy
    @Column(name = "id")
    private Long id;
    @Column(name = "b")
    private String b;

    @ManyToMany(mappedBy = "manyBList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ManyA> manyAList = new ArrayList<>();

    public ManyB() {
    }

    public ManyB(String b) {
        this.b = b;
    }
}
