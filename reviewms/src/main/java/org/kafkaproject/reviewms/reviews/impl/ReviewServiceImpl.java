package org.kafkaproject.reviewms.reviews.impl;

import org.kafkaproject.reviewms.reviews.Review;
import org.kafkaproject.reviewms.reviews.ReviewRepo;
import org.kafkaproject.reviewms.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;

    public ReviewServiceImpl(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<Review> getReviews(Long companyId) {
        return reviewRepo.findByCompanyId(companyId);
    }

    @Override
    public Review getReview(Long reviewId) {
        return reviewRepo.findById(reviewId).orElse(null);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        if (companyId != null && review != null) {
            review.setCompanyId(companyId);
            reviewRepo.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Long reviewId, Review updateReview) {
        Review review = reviewRepo.findById(reviewId).orElse(null);
        if (updateReview != null) {
            assert review != null;
            review.setTitle(updateReview.getTitle());
            review.setDescription(updateReview.getDescription());
            review.setRating(updateReview.getRating());
            review.setCompanyId(updateReview.getCompanyId());
            reviewRepo.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        if (reviewRepo.existsById(reviewId)) {
            reviewRepo.deleteById(reviewId);
            return true;
        }
        return false;
    }

}
