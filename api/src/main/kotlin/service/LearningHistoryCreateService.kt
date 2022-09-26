package service

import dto.LearningHistoryCreateDto
import dto.LearningHistoryDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class LearningHistoryCreateService(
    private val learningHistoryDomainCommandService: LearningHistoryDomainCommandService,
    private val learningScoreDomainCommandService: LearningScoreDomainCommandService,
) {

    // 학습 이력을 저장하기 위한 정보를 클라이언트로부터 받아 학습 이력 레퍼지토리에 저장해달라고 요청하는 서비스
    fun createLearningHistory(
        learningHistoryCreateDto: LearningHistoryCreateDto
    ){
        // 학습 이력 저장
        learningHistoryDomainCommandService.create(
            learningHistoryDto = LearningHistoryDto(
                memberProfileIds = learningHistoryCreateDto.memberProfileIds,
                learningHistoryType = learningHistoryCreateDto.learningHistoryType,
                actId = learningHistoryCreateDto.actId,
                contentClassification = learningHistoryCreateDto.contentClassification,
                learningTime = learningHistoryCreateDto.learningTime,
            )
        )


        // 학습 점수는 별도 테이블에 저장. 우선 learningHistory 먼저 저장하고 별도로 스코어를 저장.


    }

}