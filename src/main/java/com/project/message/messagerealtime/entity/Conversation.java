package com.project.message.messagerealtime.entity;

import com.project.message.messagerealtime.utils.enumaration.ConversationType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "conversations")
public class Conversation extends Common {

    @Column(name = "title")
    private String title;

    @Column(name = "background")
    private String background;

    @Column(name = "conversation_type")
    @Enumerated(EnumType.STRING)
    private ConversationType conversationType;

    @ManyToMany(mappedBy = "conversations")
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "conversation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Message> messages = new HashSet<>();
}
