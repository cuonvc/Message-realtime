package com.project.message.messagerealtime.entity;

import com.project.message.messagerealtime.utils.enumaration.Gender;
import com.project.message.messagerealtime.utils.enumaration.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User extends Common {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "is_root")
    @Enumerated(EnumType.STRING)
    private Role isRoot = Role.IS_MEMBER;

    @ManyToMany
    @JoinTable(
            name = "user_conversation",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "conversation_id")
    )
    private Set<Conversation> conversations = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Message> messages = new HashSet<>();

}
