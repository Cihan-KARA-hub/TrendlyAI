package com.kara.orderserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<com.kara.orderserver.entity.Orders, Long> {
}
