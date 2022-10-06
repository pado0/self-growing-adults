package com.pado.api.controller

import com.pado.api.dto.LearningHistoryCreateDto
import com.pado.api.dto.LearningHistoryRequestDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.pado.api.service.LearningHistoryCreateService
import com.pado.domain.dto.LearningHistoryDto

@RestController
@RequestMapping("/controller/learning-history")
class LearningHistoryController(
    private val learningHistoryCreateService: LearningHistoryCreateService,
) {

    @PostMapping("/create")
    fun create(@RequestBody request: LearningHistoryRequestDto): LearningHistoryDto {
        return learningHistoryCreateService.createLearningHistory(
            LearningHistoryCreateDto(
                memberProfileIds = request.memberProfileIds,
                learningTime = request.learningTime,
                learningHistoryType = request.learningHistoryType,
                contentClassification = request.contentClassification,
                actId = request.actId,
                score = request.score,
            )
        )
    }
}