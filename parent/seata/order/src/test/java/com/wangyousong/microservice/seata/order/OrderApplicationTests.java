package com.wangyousong.microservice.seata.order;

import com.wangyousong.microservice.seata.order.feign.StorageFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderApplicationTests {

    @Autowired
    private StorageFeignClient storageFeignClient;

    @Test
    void contextLoads() {
    }

    @Test
    public void deduct() {
        String commodityCode = "product-1";
        Integer count = 1;
        Boolean deduct = storageFeignClient.deduct(commodityCode, count);
        System.out.println(deduct);
    }

}
