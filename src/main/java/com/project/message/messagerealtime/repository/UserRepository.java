package com.project.message.messagerealtime.repository;

import com.project.message.messagerealtime.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.phoneNumber = :phoneOrEmail OR u.email = :phoneOrEmail")
    Optional<User> findByPhoneNumberOrEmail(@Param("phoneOrEmail") String phoneNumberOrEmail);

    @Query("SELECT u FROM User u WHERE u.phoneNumber =:phone OR u.email =:email")
    Optional<User> findByPhoneNumberOrEmail(@Param("phone") String phoneNumber,
                                            @Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.phoneNumber = :phone")
    Optional<User> findByPhoneNumber(@Param("phone") String phoneNumber);

}
