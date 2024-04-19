package com.embarkxjobappmonolithic2microservice.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    Review getReview(Long companyId, Long reviewId);
    Review updateReview(Long companyId, Long ReviewId, Review review);
    Review createReview(Long companyId, Review review);
    boolean deleteReview(Long companyId, Long ReviewId);
}
