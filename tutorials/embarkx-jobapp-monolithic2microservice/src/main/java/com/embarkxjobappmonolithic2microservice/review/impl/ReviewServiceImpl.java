package com.embarkxjobappmonolithic2microservice.review.impl;


import com.embarkxjobappmonolithic2microservice.company.Company;
import com.embarkxjobappmonolithic2microservice.company.CompanyService;
import com.embarkxjobappmonolithic2microservice.review.Review;
import com.embarkxjobappmonolithic2microservice.review.ReviewRepository;
import com.embarkxjobappmonolithic2microservice.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;
    @Override
    public List<Review> getAllReviews (Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review getReview (Long companyId, Long reviewId) {
        List<Review> reviewList = getAllReviews(companyId);
        return reviewList.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public Review updateReview (Long companyId, Long reviewId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            review.setId(reviewId);
            return reviewRepository.save(review);
        }
        return null;
    }

    @Override
    public Review createReview (Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            return reviewRepository.save(review);
        }
        return null;
    }

    @Override
    public boolean deleteReview (Long companyId, Long reviewId) {
        if (reviewRepository.existsById(reviewId)
            && companyService.getCompanyById(companyId) != null) {

            Review review = reviewRepository.findById(reviewId).orElse(null);
            if( review != null ) {
                Company company = review.getCompany();
                company.getReviews().remove(review);
                review.setCompany(null);
                companyService.updateCompany(companyId, company);
                reviewRepository.deleteById(reviewId);
                return true;
            }
        }
        return false;
    }
}
