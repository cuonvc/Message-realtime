package com.project.message.messagerealtime.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "refresh_token")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class RefreshToken {

    @Id
    @GeneratedValue(generator = "custom_id")
    private String id;

    @Column
    private String token;

    @Column(name = "expire_date")
    private Date expireDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

}
