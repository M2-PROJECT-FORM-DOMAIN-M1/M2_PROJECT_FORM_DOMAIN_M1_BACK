package com.project.database.models.role;

import com.project.database.enums.RoleNameEnum;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles",uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        }),
})
public class Role   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleNameEnum name;


    public Role() {

    }


    public Role(RoleNameEnum name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleNameEnum getName() {
        return name;
    }

    public void setName(RoleNameEnum name) {
        this.name = name;
    }

}