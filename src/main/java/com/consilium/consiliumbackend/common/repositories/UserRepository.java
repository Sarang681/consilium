package com.consilium.consiliumbackend.common.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.consilium.consiliumbackend.common.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
