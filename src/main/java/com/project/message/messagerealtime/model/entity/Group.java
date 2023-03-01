package com.project.message.messagerealtime.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "groups")
@Data
public class Group extends Conversation {

    @Column(name = "number_of_members")
    private Integer numberOfMembers;

    @Column(name = "group_photo")
    private String groupPhoto;

}
