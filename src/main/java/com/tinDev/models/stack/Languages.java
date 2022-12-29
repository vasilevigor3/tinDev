package com.tinDev.models.stack;

import com.tinDev.models.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="language", schema = "public")
public class Languages {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "languageId")
    private int languageId;

    @ManyToOne
    @JoinColumn(name="user_Id", nullable=false)
    private User user;
}
