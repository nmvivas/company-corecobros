package com.banquito.corecobros.companydoc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corecobros.companydoc.dto.CompanyDTO;
import com.banquito.corecobros.companydoc.model.Company;
import com.banquito.corecobros.companydoc.service.CompanyService;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        return ResponseEntity.ok(this.service.obtainAllCompanies());
    }

    @GetMapping("/unique/{uniqueID}")
    public ResponseEntity<CompanyDTO> getCompanyByUniqueID(@PathVariable String uniqueID) {
        CompanyDTO company = service.getCompanyByUniqueID(uniqueID);
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/ruc/{ruc}")
    public ResponseEntity<Company> getCompanyByRuc(@PathVariable String ruc) {
        try {
            Company company = service.getCompanyByRuc(ruc);
            return ResponseEntity.ok(company);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createCompany(@RequestBody CompanyDTO dto) {
        this.service.create(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCompany(@PathVariable String id, @RequestBody CompanyDTO dto) {
        this.service.updateCompany(id, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/register")
    public ResponseEntity<CompanyDTO> registerCompany(@RequestParam String ruc, @RequestParam String accountNumber) {
        try {
            CompanyDTO company = this.service.registerCompany(ruc, accountNumber);
            return ResponseEntity.ok(company);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
