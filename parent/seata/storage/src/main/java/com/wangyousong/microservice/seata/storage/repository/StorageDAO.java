package com.wangyousong.microservice.seata.storage.repository;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.wangyousong.microservice.seata.storage.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
@Mapper
@Repository
public interface StorageDAO extends BaseMapper<Storage> {

}
