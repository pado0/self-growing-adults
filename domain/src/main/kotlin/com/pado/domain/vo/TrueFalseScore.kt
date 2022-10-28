package com.pado.domain.vo

data class TrueFalseScore(
    val category: String? = null,
    val words: List<TrueFalseWordScore>,
    val missed: List<MissedWord>? = null
) : ScoreData

data class TrueFalseWordScore(
    val answer: String,
    val correct: Boolean,
)

data class MissedWord(
    val answer: String
)