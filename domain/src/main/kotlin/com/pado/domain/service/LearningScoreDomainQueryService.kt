package com.pado.domain.service

import com.pado.domain.repository.LearningScoreRepository
import com.pado.domain.type.ScoreType
import org.springframework.stereotype.Service

@Service
class LearningScoreDomainQueryService(
    private val learningScoreRepository: LearningScoreRepository,
) {
    fun getScoreDataListByLearningHistoryIdsAndScoreType(
        LearningHistoryIds: List<Long>,
        scoreType: ScoreType
    ){
        val learningScoreList = learningScoreRepository
    }

}