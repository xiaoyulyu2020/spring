package org.kafkaproject.reviewms.reviews;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public List<Review> getReviews(@PathVariable Long companyId) {
        return reviewService.getReviews(companyId);
    }

    @PostMapping("/reviews")
    public boolean addReviews(@PathVariable Long companyId, @RequestBody Review review) {
        return reviewService.addReview(companyId, review);
    }

    @GetMapping("/reviews/{reviewId}")
    public Review getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return reviewService.getReview(reviewId);
    }

    @PutMapping("/reviews/{reviewId}")
    public boolean updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        return reviewService.updateReview(reviewId, review);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public boolean deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return reviewService.deleteReview(reviewId);
    }
}
