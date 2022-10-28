package com.pado.domain.repository

import com.pado.domain.entity.LearningScore
import com.pado.domain.type.ScoreType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface LearningScoreRepository : JpaRepository<LearningScore, Long> {

    fun findByLearningHistoryIdInAndScoreType(learningHistoryIds: List<Long>, scoreType: ScoreType): List<LearningScore>
}