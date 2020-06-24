package com.wangyousong.microservice.seata.storage.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.wangyousong.microservice.seata.storage.entity.Storage;
import com.wangyousong.microservice.seata.storage.repository.StorageDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Program Name: springcloud-nacos-seata
 * <p>
 * Description:
 * <p>
 *
 * @author Bob Jackson
 * @version 1.0
 * @date 2019/8/28 4:05 PM
 */
@Service
public class StorageService {

    public static final String PRODUCT_2 = "product-2";
    @Resource
    private StorageDAO storageDAO;

    /**
     * 减库存
     *
     * @param commodityCode commodityCode
     * @param count         count
     */
    @Transactional(rollbackFor = Exception.class)
    public void deduct(String commodityCode, int count) {
        if (PRODUCT_2.equals(commodityCode)) {
            throw new RuntimeException("异常:模拟业务异常:Storage branch exception");
        }

        QueryWrapper<Storage> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new Storage().setCommodityCode(commodityCode));
        Storage storage = storageDAO.selectOne(wrapper);
        storage.setCount(storage.getCount() - count);

        storageDAO.updateById(storage);
    }
}
