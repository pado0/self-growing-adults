package dto

import constant.DB_NULL_ID
import entity.LearningHistory
import entity.LearningScore
import type.ScoreType

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