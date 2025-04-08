package com.daniel_tessi_assogba.gradle_demo_project.logic;

import com.daniel_tessi_assogba.gradle_demo_project.domain.entity.Tenant;
import com.daniel_tessi_assogba.gradle_demo_project.domain.repository.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantHelper {
    private final TenantRepository tenantRepository;

    public TenantHelper(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;

    }

    public void deleteTenant(Long id) {
        tenantRepository.deleteById(id);
    }
    public List<Tenant> getTenants() {
        return tenantRepository.findAll();
    }

    public Tenant getTenant(Long id) {
        Optional<Tenant> tenant = tenantRepository.findById(id);
        if (tenant.isPresent()) {
            return tenant.get();
        }else{
            throw new RuntimeException("Person not found");
        }
    }
}

