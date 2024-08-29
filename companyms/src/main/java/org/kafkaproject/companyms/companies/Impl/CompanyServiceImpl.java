package org.kafkaproject.companyms.companies.Impl;

import org.kafkaproject.companyms.companies.Company;
import org.kafkaproject.companyms.companies.CompanyRepo;
import org.kafkaproject.companyms.companies.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;
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
            companyRepo.save(oldCompany);
            return true;
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
