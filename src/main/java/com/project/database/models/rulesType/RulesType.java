package com.project.database.models.rulesType;

import com.project.database.enums.RulesTypeEnum;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class RulesType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RulesTypeEnum rulesTypeEnum;

    private String rulesTypeRenderText;

    public RulesType() {
    }

    public RulesType(RulesTypeEnum rulesTypeEnum, String rulesTypeRenderText) {
        this.rulesTypeEnum = rulesTypeEnum;
        this.rulesTypeRenderText = rulesTypeRenderText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RulesTypeEnum getRulesTypeEnum() {
        return rulesTypeEnum;
    }

    public void setRulesTypeEnum(RulesTypeEnum rulesTypeEnum) {
        this.rulesTypeEnum = rulesTypeEnum;
    }

    public String getRulesTypeRenderText() {
        return rulesTypeRenderText;
    }

    public void setRulesTypeRenderText(String rulesTypeRenderText) {
        this.rulesTypeRenderText = rulesTypeRenderText;
    }
}
