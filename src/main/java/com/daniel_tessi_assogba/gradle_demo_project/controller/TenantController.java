package com.daniel_tessi_assogba.gradle_demo_project.controller;

import com.daniel_tessi_assogba.gradle_demo_project.domain.entity.Tenant;
import com.daniel_tessi_assogba.gradle_demo_project.logic.CreateTenantManager;
import com.daniel_tessi_assogba.gradle_demo_project.logic.TenantHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tenant")
@Transactional
public class TenantController {

    private final TenantHelper tenantHelper;
    private final CreateTenantManager createTenantManager;

    public TenantController(TenantHelper tenantHelper, CreateTenantManager createTenantManager) {
        this.tenantHelper = tenantHelper;
        this.createTenantManager = createTenantManager;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenant(@PathVariable Long id) {
        return new ResponseEntity<>(tenantHelper.getTenant(id), null, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Tenant>> getTenants() {
        return new ResponseEntity<>(tenantHelper.getTenants(), null, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Tenant> createTenant(@RequestBody TenantDto tenantDto) {
        return new ResponseEntity<>(createTenantManager.createTenant(tenantDto), null, HttpStatus.OK);
    }
}

