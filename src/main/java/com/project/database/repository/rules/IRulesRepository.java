package com.project.database.repository.rules;

import com.project.database.models.rules.Rules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRulesRepository  extends JpaRepository<Rules, Long> {
}
