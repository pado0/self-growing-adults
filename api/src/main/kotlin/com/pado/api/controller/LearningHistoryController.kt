package com.pado.api.controller

import com.pado.api.dto.LearningHistoryCreateRequestDto
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
    fun create(@RequestBody request: LearningHistoryCreateRequestDto): LearningHistoryDto {
        return learningHistoryCreateService.createLearningHistory(request)
    }
}