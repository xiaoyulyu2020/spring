package org.kafkaproject.microservice.companies.Impl;

import org.kafkaproject.microservice.companies.Company;
import org.kafkaproject.microservice.companies.CompanyRepo;
import org.kafkaproject.microservice.companies.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepo companyRepo;
    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public void addCompany(Company company) {
        companyRepo.save(company);
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        boolean result = companyRepo.existsById(id);

        if (result) {
            Company oldCompany = companyRepo.findById(id).get();
            oldCompany.setCompanyAddress(company.getCompanyAddress());
            oldCompany.setCompanyName(company.getCompanyName());
            companyRepo.save(company);
        }
        return false;
    }

    @Override
    public boolean deleteCompany(Long id) {
        boolean result = companyRepo.existsById(id);
        if (result) {
            companyRepo.deleteById(id);
        }
        return false;
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepo.findById(id).orElse(null);
    }
}
