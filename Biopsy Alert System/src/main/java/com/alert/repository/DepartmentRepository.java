package com.alert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alert.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
