package com.project.database.models.rules;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.database.models.rulesType.RulesType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Rules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private Long abstractID;

    @OneToOne
    @JsonProperty(required = true)
    private RulesType rulesType;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;


}
