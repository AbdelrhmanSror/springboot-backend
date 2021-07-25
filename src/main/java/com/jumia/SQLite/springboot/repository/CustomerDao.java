package com.jumia.SQLite.springboot.repository;

import com.jumia.SQLite.springboot.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {}
