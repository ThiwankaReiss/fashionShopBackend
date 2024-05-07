package org.example.repository;

import org.example.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {
    Optional<CustomerEntity> findByUserName(String userName);
    Optional<CustomerEntity>  findByPassword(String password);
    Optional<CustomerEntity>  findByEmail(String email);
}
