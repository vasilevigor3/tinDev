package com.tinDev.models.stack;

import com.tinDev.models.stack.skils.AbstractSkill;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="backStack", schema = "public")
public class BackStack {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "backStackId")
    private int backStackId;

//    private List<AbstractSkill> skills;
}
