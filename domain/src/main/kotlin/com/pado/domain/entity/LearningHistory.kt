package com.pado.domain.entity

import com.pado.domain.constant.DB_NULL_ID
import com.pado.domain.vo.ContentClassification
import com.pado.domain.vo.LeaerningHistoryType
import com.pado.domain.vo.MemberProfileIds
import com.pado.domain.vo.Second
import java.time.Instant
import javax.persistence.*

@Entity
// 테이블 검색의 효율성을 더하기 위해 B-tree 구조를 사용한 인덱스를 적용한다.
// https://velog.io/@ljinsk3/JPA%EB%A1%9C-%EC%9D%B8%EB%8D%B1%EC%8A%A4-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0
// 복합인덱스 만든느 법
// https://youngwonhan-family.tistory.com/86
@Table(
    name = "learning_history",
    indexes = [
        Index(name = "idx_learning_history_member_id_profile_id", columnList = "member_id,profile_id")
    ]
)
class LearningHistory(

    /**
        회원 정보 (VO, 값타입. @Embedded)
     */
    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "memberId", column = Column(name = "member_id", nullable = false)),
        AttributeOverride(name = "profileId", column = Column(name = "profile_id", nullable = false)),
    ) // VO 내 컬럼명이 중복되므로 매핑정보 재정의
    var memberProfileIds: MemberProfileIds,

    /**
        컨텐츠 타입 (VO, 값타입. @Embedded)
     */
    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "contentId", column = Column(name = "content_id", nullable = false)),
        AttributeOverride(name = "actType", column = Column(name = "act_type", nullable = false)),
        AttributeOverride(name = "contentType", column = Column(name = "content_type", nullable = false)),
    )
    val contentClassification: ContentClassification,

    /**
        학습 이력 (ENUM 타입. @Enumerated, EnumType 지정 필요)
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "learning_history_type", nullable = false, length = 50)
    val learningHistoryType: LeaerningHistoryType,

    /**
        학습 시간 (VO, 값타입. @Embedded)
     */
    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "value", column = Column(name = "learning_time", nullable = false))
    )
    val learningTime: Second,

    @Column(name = "act_id")
    val actId: Long?,

    @Column(name = "created_at")
    val createdAt: Instant,

    ) {
    @Id @GeneratedValue
    val id: Long = DB_NULL_ID
}