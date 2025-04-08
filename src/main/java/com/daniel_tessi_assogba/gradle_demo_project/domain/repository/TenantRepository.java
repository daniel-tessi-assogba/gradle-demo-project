package com.daniel_tessi_assogba.gradle_demo_project.domain.repository;

import com.daniel_tessi_assogba.gradle_demo_project.domain.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
