package com.project.message.messagerealtime.repository;

import com.project.message.messagerealtime.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> update(User user);
    Optional<User> getUser(String userId);
    void delete(String userId);

}
