package com.pado.domain.dto

import com.pado.domain.constant.DB_NULL_ID
import com.pado.domain.entity.LearningHistory
import com.pado.domain.entity.LearningScore
import com.pado.domain.type.ScoreType

class LearningScoreDto(
    val id: Long = DB_NULL_ID,
    val scoreType: ScoreType,
    val scoreData: String,
) {
    fun toEntity(learningHistory: LearningHistory): LearningScore = LearningScore(
        scoreData = scoreData,
        scoreType = scoreType,
        learningHistory = learningHistory,
    )

    companion object{
        fun fromEntity(entity: LearningScore): LearningScoreDto = LearningScoreDto(
            id = entity.id,
            scoreType = entity.scoreType,
            scoreData = entity.scoreData,
        )
    }
}