package com.embarkxjobappmonolithic2microservice.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompaines();
    Company getCompanyById(Long companyId);
    Company createCompany(Company company);
    Company updateCompany(Long companyId, Company company);
    boolean deleteCompany(Long companyId);
}
