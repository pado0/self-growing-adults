package com.pado.api.dto

import com.pado.domain.dto.LearningScoreDto
import com.pado.domain.vo.ContentClassification
import com.pado.domain.vo.LeaerningHistoryType
import com.pado.domain.vo.MemberProfileIds
import com.pado.domain.vo.Second

// learningHistory 저장시 클라이언트에서 보낼 데이터를 선별하기 위한 용도의 dto
data class LearningHistoryCreateDto(
    val memberProfileIds: MemberProfileIds,
    val contentClassification: ContentClassification,
    val learningHistoryType: LeaerningHistoryType,
    val learningTime: Second,
    val actId: Long,
    val score: List<LearningScoreDto>?,
){
    companion object {
        fun of(
            memberProfileIds: MemberProfileIds,
            contentClassification: ContentClassification,
            learningHistoryType: LeaerningHistoryType,
            learningTime: Second,
            actId: Long,
            score: List<LearningScoreDto>?
        ) = LearningHistoryCreateDto(
            memberProfileIds = memberProfileIds,
            contentClassification = contentClassification,
            learningHistoryType = learningHistoryType,
            learningTime = learningTime,
            actId = actId,
            score = score,
        )
    }
}