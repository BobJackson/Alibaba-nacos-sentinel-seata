package com.wangyousong.microservice.seata.order.controller;


import com.wangyousong.microservice.seata.order.service.OrderService;
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
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;


    /**
     * 下单：插入订单表、扣减库存，模拟回滚
     *
     * @return Boolean
     */
    @RequestMapping("/placeOrder/commit")
    public Boolean placeOrderCommit() {

        orderService.placeOrder("1", "product-1", 1);
        return true;
    }

    /**
     * 下单：插入订单表、扣减库存，模拟回滚
     *
     * @return Boolean
     */
    @RequestMapping("/placeOrder/rollback")
    public Boolean placeOrderRollback() {
        // product-2 扣库存时模拟了一个业务异常,
        orderService.placeOrder("1", "product-2", 1);
        return true;
    }


    @RequestMapping("/placeOrder")
    public Boolean placeOrder(String userId, String commodityCode, Integer count) {
        orderService.placeOrder(userId, commodityCode, count);
        return true;
    }
}
