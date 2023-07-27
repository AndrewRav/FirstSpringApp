package com.bbtutorials.users.repository;

import com.bbtutorials.users.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
