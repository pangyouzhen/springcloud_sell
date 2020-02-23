package com.imooc.order.respository;

import com.imooc.order.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * (OrderMaster)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-23 19:03:24
 */
public interface OrderMasterRespository extends JpaRepository<OrderMaster, String> {


}