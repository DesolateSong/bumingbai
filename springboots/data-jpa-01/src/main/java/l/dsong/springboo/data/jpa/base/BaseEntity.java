package l.dsong.springboo.data.jpa.base;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseEntity implements  java.io.Serializable{

    @Id
    @GeneratedValue(
            generator = "custom-id"
            , strategy = GenerationType.AUTO
    )
    @GenericGenerator(
            name="custom-id"
            ,strategy = "l.dsong.springboo.data.jpa.config.DataUUIDGenerator"
    )
    protected String id;

}
