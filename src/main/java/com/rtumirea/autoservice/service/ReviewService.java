package com.rtumirea.autoservice.service;

import com.rtumirea.autoservice.dao.entity.ReviewEntity;
import com.rtumirea.autoservice.dao.repository.ReviewRepository;
import com.rtumirea.autoservice.exception.AutoServiceException;
import com.rtumirea.autoservice.mapper.entity.ReviewEntityMapper;
import com.rtumirea.autoservice.mapper.model.ReviewModelMapper;
import com.rtumirea.autoservice.model.ImageModel;
import com.rtumirea.autoservice.model.ReviewModel;
import com.rtumirea.autoservice.model.ServiceCenterModel;
import com.rtumirea.autoservice.model.UserModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final UserService userService;
    private final ServiceCenterService serviceCenterService;
    private final ReviewRepository reviewRepository;
    private final ReviewEntityMapper reviewEntityMapper;
    private final ReviewModelMapper reviewModelMapper;

    @Transactional
    public ReviewModel createReview(String userEmail, String userComment, Long serviceCenterId){
        log.info("Creating review(userEmail={}, userComment={}, serviceId={})", userEmail, userComment, serviceCenterId);
        UserModel userModel = userService.getUser(userEmail);
        ServiceCenterModel serviceCenterModel = serviceCenterService.getServiceCenter(serviceCenterId);
        ReviewModel reviewModel = ReviewModel.builder()
                .comment(userComment)
                .userModel(userModel)
                .serviceCenterModel(serviceCenterModel)
                .build();
        ReviewEntity reviewEntity = reviewEntityMapper.toEntity(reviewModel);
        reviewEntity = reviewRepository.save(reviewEntity);
        return reviewModelMapper.toModel(reviewEntity);
    }

    @Transactional
    public ReviewModel updateReview(Long reviewId, String reviewComment){
        log.info("Updating review(reviewId={}, reviewComment={})", reviewId, reviewComment);
        Optional<ReviewEntity> optReview = reviewRepository.findById(reviewId);
        if (optReview.isPresent()){
            ReviewEntity reviewEntity = optReview.get();
            reviewEntity.setComment(reviewEntity.getComment());
            reviewEntity = reviewRepository.save(reviewEntity);
            return reviewModelMapper.toModel(reviewEntity);
        } else {
            String message = String.format("Unable to find review(id=%d, comment=%s)", reviewId, reviewComment);
            log.error(message);
            throw new AutoServiceException(message);
        }
    }

    @Transactional
    public void deleteReview(Long reviewId){
        Optional<ReviewEntity> optReview = reviewRepository.findById(reviewId);
        if (optReview.isPresent()){
            ReviewEntity reviewEntity = optReview.get();
            log.info("Deleting review(id={}, comment={})", reviewId, reviewEntity.getComment());
            reviewRepository.delete(reviewEntity);
        } else {
            String message = String.format("Unable to find review(id=%d)", reviewId);
            log.error(message);
            throw new AutoServiceException(message);
        }
    }
}
