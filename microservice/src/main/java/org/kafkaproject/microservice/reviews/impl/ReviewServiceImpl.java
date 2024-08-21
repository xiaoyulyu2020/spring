package org.kafkaproject.microservice.reviews.impl;

import org.kafkaproject.microservice.companies.Company;
import org.kafkaproject.microservice.companies.CompanyService;
import org.kafkaproject.microservice.reviews.Review;
import org.kafkaproject.microservice.reviews.ReviewRepo;
import org.kafkaproject.microservice.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepo reviewRepo, CompanyService companyService) {
        this.reviewRepo = reviewRepo;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getReviews(Long companyId) {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews.stream().filter(r -> r.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompany(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepo.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review review) {
        Company company = companyService.getCompany(companyId);
        if (company != null) {
            review.setCompany(company);
            review.setId(reviewId);
            reviewRepo.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        Company company = companyService.getCompany(companyId);
        boolean reviewExists = reviewRepo.existsById(reviewId);
        if (company != null && reviewExists) {
            company.getReviews().removeIf(r -> r.getId().equals(reviewId));
            companyService.updateCompany(companyId, company);
            reviewRepo.deleteById(reviewId);
            return true;
        }
        return false;
    }


}
