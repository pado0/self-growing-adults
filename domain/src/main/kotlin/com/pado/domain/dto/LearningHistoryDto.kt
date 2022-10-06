package com.pado.domain.dto

import com.pado.domain.constant.DB_NULL_ID
import com.pado.domain.entity.LearningHistory
import com.pado.domain.vo.ContentClassification
import com.pado.domain.vo.LeaerningHistoryType
import com.pado.domain.vo.MemberProfileIds
import com.pado.domain.vo.Second
import java.time.Instant

data class LearningHistoryDto(
    val id: Long = DB_NULL_ID,
    val memberProfileIds: MemberProfileIds,
    val contentClassification: ContentClassification,
    val learningHistoryType: LeaerningHistoryType,
    val actId: Long?,
    val learningTime: Second,
    val createdAt: Instant = Instant.now(),
){
    fun toEntity(): LearningHistory = LearningHistory(
        memberProfileIds = memberProfileIds,
        contentClassification = contentClassification,
        learningHistoryType = learningHistoryType,
        learningTime = learningTime,
        actId = actId,
        createdAt = createdAt,
    )

    companion object {
        fun fromEntity(learningHistory: LearningHistory): LearningHistoryDto =
            LearningHistoryDto(
                id = learningHistory.id,
                memberProfileIds = learningHistory.memberProfileIds,
                contentClassification = learningHistory.contentClassification,
                learningHistoryType = learningHistory.learningHistoryType,
                learningTime = learningHistory.learningTime,
                actId = learningHistory.actId,
                createdAt = learningHistory.createdAt,
            )
    }


}

