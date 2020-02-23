package com.imooc.order.respository;

import com.imooc.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * (OrderDetail)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-23 19:03:14
 */
public interface OrderDetailRespository extends JpaRepository<OrderDetail, String> {
}