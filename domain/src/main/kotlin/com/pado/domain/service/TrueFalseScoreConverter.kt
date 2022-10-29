package com.pado.domain.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.pado.domain.type.ScoreType
import com.pado.domain.vo.ScoreData
import com.pado.domain.vo.TrueFalseScore
import org.springframework.stereotype.Component

@Component
class TrueFalseScoreConverter(
    private val objectMapper: ObjectMapper
) : ScoreDataConverter {
    override fun getData(json: String): ScoreData {
        return objectMapper.readValue(json, TrueFalseScore::class.java)
    }

    override fun support(scoreType: ScoreType): Boolean {
        return scoreType == SCORE_TYPE
    }

    companion object{
        val SCORE_TYPE = ScoreType.TRUE_FALSE
    }
}