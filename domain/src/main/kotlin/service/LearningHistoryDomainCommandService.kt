package service

import dto.LearningHistoryDto
import entity.LearningHistory
import org.springframework.stereotype.Service
import repository.LearningHistoryRepository
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