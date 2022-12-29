package com.tinDev.models.user;

import jakarta.persistence.*;
import lombok.Data;
import com.tinDev.models.user.enums.Carrier;
import com.tinDev.models.user.enums.Seniority;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@Entity
@Table(name="position", schema = "public")
public class Position {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "positionId")
    private int userId;
    @Column(name = "carrier")
    private Carrier carrier;
    @Column(name = "seniority")
    private Seniority seniority;

//    @OneToOne(mappedBy = "position")
//    private User user;
}
