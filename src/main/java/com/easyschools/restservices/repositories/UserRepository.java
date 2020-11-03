package com.easyschools.restservices.repositories;

import com.easyschools.restservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     Optional<User> findBySsn(String ssn);
}
