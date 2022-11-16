package l.dsong.springboot.data.jpa.v2.entity;

import l.dsong.springboot.data.jpa.v1.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "t_tree")
@EqualsAndHashCode(callSuper = true)
public class Tree extends BaseEntity {

    @Column(name = "tree_name")
    private String treeName;

    @Column(name = "p_id")
    private Long pId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "p_id", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<Tree> subTree = new ArrayList<>();

    public Tree() {
    }

    public Tree(String treeName) {
        this.treeName = treeName;
    }

    public Tree(Long id) {
        super(id);
        this.treeName = treeName;
    }
}
