package service

import dto.LearningScoreDto
import entity.LearningHistory
import entity.LearningScore
import org.springframework.stereotype.Service
import repository.LearningScoreRepository
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