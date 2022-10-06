package com.pado.domain.service

import com.pado.domain.dto.LearningScoreDto
import com.pado.domain.entity.LearningHistory
import com.pado.domain.entity.LearningScore
import org.springframework.stereotype.Service
import com.pado.domain.repository.LearningScoreRepository
import javax.transaction.Transactional

@Transactional
@Service
class LearningScoreDomainCommandService(
    private val learningScoreRepository: LearningScoreRepository,
) {
    fun create(
        learningScoreDto: LearningScoreDto,
        learningHistory: LearningHistory,
    ): LearningScoreDto {
        return learningScoreRepository.save(learningScoreDto.toEntity(learningHistory = learningHistory))
            .let { x -> LearningScoreDto.fromEntity(x)}
    }
}