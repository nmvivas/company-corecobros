package com.banquito.corecobros.companydoc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.corecobros.companydoc.model.Company;

public interface CompanyRepository extends MongoRepository<Company, String> {

    Company findByRuc(String ruc);

    List<Company> findByCompanyName(String companyName);

    List<Company> findByCompanyNameContainingIgnoreCase(String companyName);

    Company findByUniqueId(String uniqueId);

    Company findByCommissionId(String commissionId);

    List<Company> findByAccountsCodeInternalAccount(String codeInternalAccount);

    List<Company> findByServiceesName(String name);

    List<Company> findByAccountsUniqueId(String uniqueId);

}
