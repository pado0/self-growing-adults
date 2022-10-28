package com.pado.domain.service

import com.pado.domain.dto.ScoreDataDto
import com.pado.domain.repository.LearningScoreRepository
import com.pado.domain.type.ScoreType
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class LearningScoreDomainQueryService(
    private val learningScoreRepository: LearningScoreRepository,
    private val scoreDataConverterList: List<ScoreDataConverter>
) {
    fun getScoreDataListByLearningHistoryIdsAndScoreType(
        learningHistoryIds: List<Long>,
        scoreType: ScoreType
    ): List<ScoreDataDto> {
        val learningScoreList = learningScoreRepository.findByLearningHistoryIdInAndScoreType(
            learningHistoryIds = learningHistoryIds,
            scoreType = scoreType,
        )

        val converter = getLearningScoreDataConverter(scoreType = scoreType) // scoreType별 컨버터 가져오기
        return learningScoreList.map {
            ScoreDataDto(
                createdAt = it.createdAt,
                scoreData = converter.getData(json = it.scoreData) // scoreData json string을 컨버터로 getData
            )
        }
    }

    private fun getLearningScoreDataConverter(scoreType: ScoreType): ScoreDataConverter {
        return  scoreDataConverterList.firstOrNull { it.support(scoreType = scoreType) }
            ?: throw IllegalArgumentException("score data converter를 찾을 수 없습니다. scoreType = $scoreType")
    }
}