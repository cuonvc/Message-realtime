package com.project.message.messagerealtime.repository;

import com.project.message.messagerealtime.model.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

    @Query("SELECT t FROM RefreshToken t WHERE t.token = :tokenRefresh AND t.expireDate > :expireDate")
    Optional<RefreshToken> findByTokenRefresh(@Param("tokenRefresh") String tokenRefresh,
                                              @Param("expireDate") Date expireDate);

    @Query("SELECT t FROM RefreshToken t WHERE t.user.email = :username OR t.user.phoneNumber = :username")
    Optional<RefreshToken> findByUsername(@Param("username") String username);
}
