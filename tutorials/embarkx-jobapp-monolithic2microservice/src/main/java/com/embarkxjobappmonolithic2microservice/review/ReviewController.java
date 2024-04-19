package com.embarkxjobappmonolithic2microservice.review;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies/{companyId}")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long companyId) {
        List<Review> reviewList = reviewService.getAllReviews(companyId);
        return new ResponseEntity<>(reviewList, HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Review review = reviewService.getReview(companyId,reviewId);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(review, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> createCompanyReview(@PathVariable Long companyId, @RequestBody Review review) {
        Review newreview = reviewService.createReview(companyId, review);
        if (newreview != null) {
            return new ResponseEntity<>(newreview, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(newreview,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        Review review1 = reviewService.updateReview(companyId,reviewId, review);
        if (review1 != null) {
            return new ResponseEntity<>(review1, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(review1, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        if (reviewService.deleteReview(companyId, reviewId)) {
            return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("not deleted",HttpStatus.NOT_FOUND);
    }
}
