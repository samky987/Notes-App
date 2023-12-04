package com.agridence.microservice.Assignment.Repository;

import com.agridence.microservice.Assignment.Model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>
{
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

}