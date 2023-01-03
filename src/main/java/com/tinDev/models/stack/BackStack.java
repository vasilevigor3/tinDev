package com.tinDev.models.stack;

import com.tinDev.models.stack.skils.AbstractSkill;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "back_stack")
public class BackStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "backStack")
    private TechStack techStack;
}
