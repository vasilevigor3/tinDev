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
@Table(name="frontStack", schema = "public")
public class FrontStack {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "frontStackId")
    private int frontStackId;

//    private List<AbstractSkill> skills;
}
