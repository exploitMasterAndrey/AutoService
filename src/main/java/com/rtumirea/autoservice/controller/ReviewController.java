package com.rtumirea.autoservice.controller;

import com.rtumirea.autoservice.dto.CreateReviewReqDto;
import com.rtumirea.autoservice.dto.ReviewRspDto;
import com.rtumirea.autoservice.dto.UpdateReviewReqDto;
import com.rtumirea.autoservice.mapper.dto.ReviewRspDtoMapper;
import com.rtumirea.autoservice.model.ReviewModel;
import com.rtumirea.autoservice.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/${spring.application.name}/v1/review")
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewRspDtoMapper reviewRspDtoMapper;

    @PostMapping("/create")
    public ReviewRspDto createReview(@Valid @RequestBody CreateReviewReqDto createReviewReqDto){
        log.info("Received create review request({})", createReviewReqDto);
        ReviewModel reviewModel = reviewService.createReview(createReviewReqDto.getUserEmail(), createReviewReqDto.getUserComment(), createReviewReqDto.getServiceId());
        return reviewRspDtoMapper.toDto(reviewModel);
    }

    @PatchMapping("/update")
    public ReviewRspDto updateReview(@Valid @RequestBody UpdateReviewReqDto updateReviewReqDto){
        log.info("Received update review request({})", updateReviewReqDto);
        ReviewModel reviewModel = reviewService.updateReview(updateReviewReqDto.getReviewId(), updateReviewReqDto.getUserComment());
        return reviewRspDtoMapper.toDto(reviewModel);
    }

    @DeleteMapping("/delete/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId){
        log.info("Received delete review request(reviewId={})", reviewId);
        reviewService.deleteReview(reviewId);
    }
}
