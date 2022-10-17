package com.pado.api.controller

import com.pado.api.dto.LearningHistoryRequestDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.pado.api.service.LearningHistoryCreateService
import com.pado.api.dto.LearningHistoryCreateDto
import com.pado.domain.dto.LearningHistoryDto
import com.pado.domain.vo.ContentClassification
import com.pado.domain.vo.MemberProfileIds
import com.pado.domain.vo.Second

@RestController
@RequestMapping("/controller/learning-history")
class LearningHistoryController(
    private val learningHistoryCreateService: LearningHistoryCreateService,
) {

    @PostMapping("/create")
    fun create(@RequestBody request: LearningHistoryRequestDto): LearningHistoryDto {
        return learningHistoryCreateService.createLearningHistory(
            LearningHistoryCreateDto.of(
                memberProfileIds = MemberProfileIds(
                    memberId = request.memberId,
                    profileId = request.profileId
                ),
                learningTime = Second(
                    value = request.learningTime
                ),
                learningHistoryType = request.learningHistoryType,
                contentClassification = ContentClassification(
                    contentType = request.contentType,
                    actType = request.actType,
                    contentId = request.contentId
                ),
                actId = request.actId,
                score = request.score,
            )
        )
    }
}