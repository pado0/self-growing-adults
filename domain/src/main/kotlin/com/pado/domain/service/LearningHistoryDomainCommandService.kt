package com.pado.domain.service

import com.pado.domain.dto.LearningHistoryDto
import com.pado.domain.entity.LearningHistory
import org.springframework.stereotype.Service
import com.pado.domain.repository.LearningHistoryRepository
import javax.transaction.Transactional

@Service
@Transactional
class LearningHistoryDomainCommandService(
    private val learningHistoryRepository: LearningHistoryRepository,
) {
    fun create(
        learningHistoryDto: LearningHistoryDto
    ): LearningHistory {
        return learningHistoryRepository.save(
            learningHistoryDto.toEntity(),
        )
    }

}