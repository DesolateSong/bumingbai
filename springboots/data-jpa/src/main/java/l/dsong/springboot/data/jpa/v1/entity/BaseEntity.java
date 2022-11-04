package l.dsong.springboot.data.jpa.v1.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseEntity {

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    @Id
    @CreatedBy
    @Column(name = "id")
    private Long id;

    @Column(name = "create_time")
    @CreatedDate
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Transient
    private LocalDateTime startDate;
    @Transient
    private LocalDateTime endDate;

}
