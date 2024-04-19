package com.embarkxjobappmonolithic2microservice.company;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companyList = companyService.getAllCompaines();
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        Company newcompany = companyService.getCompanyById(companyId);
        if (newcompany != null) {
            return new ResponseEntity<>(newcompany, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(newcompany, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company newcompany = companyService.createCompany(company);
        return new ResponseEntity<>(newcompany, HttpStatus.CREATED);
    }



    @PutMapping("/{companyId}")
    public ResponseEntity<Company> updateJob(@PathVariable Long companyId, @RequestBody Company company) {
        Company updatedCompany = companyService.updateCompany(companyId, company);
        if (updatedCompany != null) {
            return new ResponseEntity<>(updatedCompany, HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>(updatedCompany, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteJob(@PathVariable Long companyId) {
        if (companyService.deleteCompany(companyId)) {
            return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("not deleted",HttpStatus.NOT_FOUND);
    }
}
