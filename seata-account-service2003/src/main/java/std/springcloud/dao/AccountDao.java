package std.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author zhuyc
 */
@Mapper
public interface AccountDao {

    /**
     * 扣减账户余额
     *
     * @param userId:
     * @param money   :
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
