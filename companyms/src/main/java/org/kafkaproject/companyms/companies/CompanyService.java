package org.kafkaproject.companyms.companies;


import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void addCompany(Company company);
    boolean updateCompany(Long id, Company company);
    boolean deleteCompany(Long id);
    Company getCompany(Long id);
}
