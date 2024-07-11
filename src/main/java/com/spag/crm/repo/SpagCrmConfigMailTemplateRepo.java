package com.spag.crm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spag.crm.model.SpagCrmConfigMailTemplate;

public interface SpagCrmConfigMailTemplateRepo extends JpaRepository<SpagCrmConfigMailTemplate,Long>
{
	SpagCrmConfigMailTemplate findByMtTemplateType(String mtTemplateType);
}
