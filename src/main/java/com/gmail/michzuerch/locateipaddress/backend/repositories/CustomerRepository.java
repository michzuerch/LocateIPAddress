package com.gmail.michzuerch.locateipaddress.backend.repositories;

import com.gmail.michzuerch.locateipaddress.backend.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
