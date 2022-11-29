package l.dsong.springboo.data.jpa.config;

import com.alibaba.druid.util.StringUtils;
import l.dsong.springboo.data.jpa.base.BaseEntity;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class DataUUIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        if (object instanceof BaseEntity) {
            BaseEntity obj = (BaseEntity) object;
            if (!StringUtils.isEmpty(obj.getId())) {
                return obj.getId();
            }
        }
        return UUID.randomUUID().toString();
    }

}
