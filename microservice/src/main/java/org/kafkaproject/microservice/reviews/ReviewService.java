package org.kafkaproject.microservice.reviews;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {

    List<Review> getReviews(Long companyId);
    Review getReview(Long companyId, Long reviewId);
    boolean addReview(Long companyId, Review review);
    boolean updateReview(Long companyId, Long reviewId, Review review);
    boolean deleteReview(Long companyId, Long reviewId);

}
