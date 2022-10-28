package com.pado.domain.dto

import com.pado.domain.vo.ScoreData
import java.time.Instant

class ScoreDataDto(
    val createdAt: Instant,
    val scoreData: ScoreData,
)
