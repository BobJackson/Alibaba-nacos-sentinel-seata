package com.wangyousong.microservice.seata.storage.controller;


import com.wangyousong.microservice.seata.storage.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 减库存
     *
     * @param commodityCode 商品代码
     * @param count         数量
     * @return Boolean
     */
    @RequestMapping(path = "/deduct")
    public Boolean deduct(String commodityCode, Integer count) {
        storageService.deduct(commodityCode, count);
        return true;
    }

}
