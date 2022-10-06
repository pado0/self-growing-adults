package com.pado.api.dto

import com.pado.domain.dto.LearningScoreDto
import com.pado.domain.type.ActType
import com.pado.domain.type.ContentType
import com.pado.domain.vo.ContentClassification
import com.pado.domain.vo.LeaerningHistoryType
import com.pado.domain.vo.MemberProfileIds
import com.pado.domain.vo.Second
import javax.persistence.EnumType
import javax.persistence.Enumerated

data class LearningHistoryRequestDto(
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
    companion object {
        fun toCreateDto(

        ): LearningHistoryCreateDto {
            return LearningHistoryCreateDto(
                memberProfileIds = MemberProfileIds(memberId = this.memberId, profileId = this.profileId),
                learningTime = Second(value = request.learningTime),
                learningHistoryType = request.learningHistoryType,
                contentClassification = ContentClassification(
                    contentType = request.contentType,
                    actType = request.actType,
                    contentId = request.contentId
                ),
                actId = request.actId,
                score = request.score,
            )
        }
    }
}