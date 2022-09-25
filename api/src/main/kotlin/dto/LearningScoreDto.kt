package dto

import type.ScoreType

data class LearningScoreDto(
    val scoreType: ScoreType,
    val scoreData: String,
)