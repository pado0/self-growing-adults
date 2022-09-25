package dto

import type.ActType
import vo.ContentClassification
import vo.LeaerningHistoryType
import vo.MemberProfileIds
import vo.Second

// learningHistory 저장시 클라이언트에서 보낼 데이터를 선별하기 위한 용도의 dto
data class LearningHistoryCreateDto(
    val memberProfileIds: MemberProfileIds,
    val contentClassification: ContentClassification,
    val learningHistoryType: LeaerningHistoryType,
    val learningTime: Second,
    val actId: Long,
    val score: List<LearningScoreDto>,
)