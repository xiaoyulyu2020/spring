package org.kafkaproject.reviewms.reviews;

import java.util.List;

public interface ReviewService {

    List<Review> getReviews(Long companyId);
    Review getReview(Long reviewId);
    boolean addReview(Long companyId, Review review);
    boolean updateReview(Long reviewId, Review review);
    boolean deleteReview(Long reviewId);

}
