package com.embarkxjobappmonolithic2microservice.company.impl;

import com.embarkxjobappmonolithic2microservice.company.Company;
import com.embarkxjobappmonolithic2microservice.company.CompanyRepository;
import com.embarkxjobappmonolithic2microservice.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompaines () {
        return  companyRepository.findAll();
    }

    @Override
    public Company getCompanyById (Long companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    @Override
    public Company createCompany (Company company) {
        return  companyRepository.save(company);
    }

    @Override
    public Company updateCompany (Long companyId, Company company) {
        Company updatecompany = getCompanyById(companyId);
        if (updatecompany != null) {
            updatecompany.setDescription(company.getDescription());
            updatecompany.setName(company.getName());
            companyRepository.save(updatecompany);
        }
        return updatecompany;
    }

    @Override
    public boolean deleteCompany (Long companyId) {
        Company company = getCompanyById(companyId);
        if (company != null) {
            companyRepository.delete(company);
            return true;
        }
        return false;
    }
}
