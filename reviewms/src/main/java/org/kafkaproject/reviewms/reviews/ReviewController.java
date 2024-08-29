package org.kafkaproject.reviewms.reviews;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getReviews(@RequestParam Long companyId) {
        return reviewService.getReviews(companyId);
    }
// /reviews?companyId={companyId}
    @PostMapping
    public boolean addReviews(@RequestParam Long companyId, @RequestBody Review review) {
        return reviewService.addReview(companyId, review);
    }

    @GetMapping("/{reviewId}")
    public Review getReview(@PathVariable Long reviewId) {
        return reviewService.getReview(reviewId);
    }

    @PutMapping("/{reviewId}")
    public boolean updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        return reviewService.updateReview(reviewId, review);
    }

    @DeleteMapping("/{reviewId}")
    public boolean deleteReview(@PathVariable Long reviewId) {
        return reviewService.deleteReview(reviewId);
    }
}
