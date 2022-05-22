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

    String specifiedValue;

    @OneToOne
    @JsonProperty(required = true)
    private RulesType rulesType;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;


    public String getSpecifiedValue() {
        return specifiedValue;
    }

    public void setSpecifiedValue(String specifiedValue) {
        this.specifiedValue = specifiedValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAbstractID() {
        return abstractID;
    }

    public void setAbstractID(Long abstractID) {
        this.abstractID = abstractID;
    }

    public RulesType getRulesType() {
        return rulesType;
    }

    public void setRulesType(RulesType rulesType) {
        this.rulesType = rulesType;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
