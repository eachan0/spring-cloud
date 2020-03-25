package std.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhuyc
 */
@Mapper
public interface StorageDao {

    /**
     * 扣减库存
     * @param productId :
     * @param count :
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
