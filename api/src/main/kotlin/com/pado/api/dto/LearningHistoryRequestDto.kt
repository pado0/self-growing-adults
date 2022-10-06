package com.pado.api.dto

import com.pado.domain.dto.LearningScoreDto
import com.pado.domain.vo.ContentClassification
import com.pado.domain.vo.LeaerningHistoryType
import com.pado.domain.vo.MemberProfileIds
import com.pado.domain.vo.Second

data class LearningHistoryRequestDto(
    val memberProfileIds: MemberProfileIds,
    val contentClassification: ContentClassification,
    val learningHistoryType: LeaerningHistoryType,
    val learningTime: Second,
    val actId: Long,
    val score: List<LearningScoreDto>?,
)