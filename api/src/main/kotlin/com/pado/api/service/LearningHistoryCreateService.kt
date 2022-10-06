package com.pado.api.service

import com.pado.api.dto.LearningHistoryCreateDto
import com.pado.domain.dto.LearningHistoryDto
import com.pado.domain.dto.LearningScoreDto
import org.springframework.stereotype.Service
import com.pado.domain.service.LearningHistoryDomainCommandService
import com.pado.domain.service.LearningScoreDomainCommandService
import javax.transaction.Transactional

@Service
@Transactional
class LearningHistoryCreateService(
    private val learningHistoryDomainCommandService: LearningHistoryDomainCommandService,
    private val learningScoreDomainCommandService: LearningScoreDomainCommandService,

    ) {

    // 학습 이력을 저장하기 위한 정보를 클라이언트로부터 받아 학습 이력 레퍼지토리에 저장해달라고 요청하는 서비스
    // 카프카나 API가 이 fun을 호출해서 학습 이력을 저장하면 됨
    fun createLearningHistory(
        learningHistoryCreateDto: LearningHistoryCreateDto
    ): LearningHistoryDto {
        // 학습 이력 저장
        val savedHistory = learningHistoryDomainCommandService.create(
            learningHistoryDto = LearningHistoryDto(
                memberProfileIds = learningHistoryCreateDto.memberProfileIds,
                learningHistoryType = learningHistoryCreateDto.learningHistoryType,
                actId = learningHistoryCreateDto.actId,
                contentClassification = learningHistoryCreateDto.contentClassification,
                learningTime = learningHistoryCreateDto.learningTime,
            )
        )


        // 학습 점수는 별도 테이블에 저장. 우선 learningHistory 먼저 저장하고 별도로 스코어를 저장.
        learningHistoryCreateDto.score?.let {
            if (learningHistoryCreateDto.score.isNotEmpty()) {
                learningHistoryCreateDto.score.map {
                    learningScoreDomainCommandService.create(
                        learningScoreDto = LearningScoreDto(
                            scoreData = it.scoreData,
                            scoreType = it.scoreType,
                        ),
                        learningHistory = savedHistory,
                    )
                }
            }
        }

        return LearningHistoryDto.fromEntity(learningHistory = savedHistory)
    }

}