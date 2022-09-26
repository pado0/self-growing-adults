package service

import dto.LearningHistoryDto
import entity.LearningHistory
import org.springframework.stereotype.Service
import repository.LearningHistoryRepository

@Service
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