package l.dsong.springboot.data.jpa.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JPAAuditAware implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        Snowflake snowflake = IdUtil.getSnowflake(1,1);
        Long id = snowflake.nextId();
        return Optional.of(id);
    }
}
