package com.tinDev.models.stack;

import com.tinDev.models.Vacancy;
import com.tinDev.models.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="techStack", schema = "public")
public class TechStack {
        @jakarta.persistence.Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "techStackId")
        private int techStackId;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "backStack_id", referencedColumnName = "backStackId")
        private BackStack backStack;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "frontStack_id", referencedColumnName = "frontStackId")
        private FrontStack frontStack;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "qaStack_id", referencedColumnName = "qaStackId")
        private QAStack qaStack;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "designerStack_id", referencedColumnName = "designerStackId")
        private DesignerStack designerStack;

        @ManyToOne(cascade=CascadeType.ALL)
        @JoinColumn(name="userId", nullable=false)
        private User user;
        @ManyToOne(cascade=CascadeType.ALL)
        @JoinColumn(name="vacancyId", nullable=false)
        private Vacancy vacancy;
}
