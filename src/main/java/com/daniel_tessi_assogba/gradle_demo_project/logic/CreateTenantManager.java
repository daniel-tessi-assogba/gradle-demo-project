package com.daniel_tessi_assogba.gradle_demo_project.logic;

import com.daniel_tessi_assogba.gradle_demo_project.config.AppTenantContext;
import com.daniel_tessi_assogba.gradle_demo_project.config.SequenceHandler;
import com.daniel_tessi_assogba.gradle_demo_project.controller.TenantDto;
import com.daniel_tessi_assogba.gradle_demo_project.domain.entity.Tenant;
import com.daniel_tessi_assogba.gradle_demo_project.domain.repository.TenantRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTenantManager {
    private final TenantRepository tenantRepository;
    private final SequenceHandler sequenceHandler;


    public CreateTenantManager(TenantRepository tenantRepository, SequenceHandler sequenceHandler) {
        this.tenantRepository = tenantRepository;
        this.sequenceHandler = sequenceHandler;
    }

    public Tenant createTenant(TenantDto tenantDto) {

        // Get the current tenant schema (e.g., "tenant1", "tenant2", etc.)
        String tenantSchema = AppTenantContext.getCurrentTenant();

        // Log the tenant schema to ensure it is not null or empty
        if (tenantSchema == null || tenantSchema.isEmpty()) {
            throw new IllegalArgumentException("Tenant schema is missing or invalid");
        }

        // Construct the full sequence name dynamically
        String sequenceName = tenantSchema + ".tenant_id_seq";

        // Use the dynamic sequence name to generate a unique tenant ID
        Tenant tenant = new Tenant();
        tenant.setId(Long.valueOf(sequenceHandler.generateId(sequenceName)));
        tenant.setName(tenantDto.getName());
        tenant.setAge(tenantDto.getAge());
        tenant.setEmail(tenantDto.getEmail());

        return tenantRepository.save(tenant);
    }
}

