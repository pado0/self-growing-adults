package com.pado.domain.service

import com.pado.domain.type.ScoreType
import com.pado.domain.vo.ScoreData

interface ScoreDataConverter {

    fun getData(json: String): ScoreData
    fun support(scoreType: ScoreType): Boolean
}