package std.springcloud.service;


/**
 * @author zhuyc
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param productId :
     * @param count :
     */
    void decrease(Long productId, Integer count);
}
