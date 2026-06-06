package com.alert.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alert.entity.BiopsyOrder;

@Repository
public interface BiopsyOrderRepository extends JpaRepository<BiopsyOrder, Long>{

}
