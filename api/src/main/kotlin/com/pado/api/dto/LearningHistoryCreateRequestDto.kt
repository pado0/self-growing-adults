package com.pado.api.dto

import com.pado.domain.dto.LearningScoreDto
import com.pado.domain.type.ActType
import com.pado.domain.type.ContentType
import com.pado.domain.vo.LeaerningHistoryType

data class LearningHistoryCreateRequestDto(
    val memberId: Long,
    val profileId: Long,
    val contentId: String,
    val actType: ActType,
    val contentType: ContentType,
    val learningHistoryType: LeaerningHistoryType,
    val learningTime: Int,
    val actId: Long,
    val score: List<LearningScoreDto>?,
) {

}