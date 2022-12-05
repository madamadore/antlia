package it.antlia.store.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.antlia.store.model.JwtUser;

public interface UserRepository extends CrudRepository<JwtUser, Integer>{
    Optional<JwtUser> findByUsername(String username);
}
