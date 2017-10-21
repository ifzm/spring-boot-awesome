package com.ifzm.repository;

import com.ifzm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public interface UserRepository extends JpaRepository<User, Serializable> {

    /**
     * @param email email
     * @return users
     */
    List<User> findByEmail(String email);
}
