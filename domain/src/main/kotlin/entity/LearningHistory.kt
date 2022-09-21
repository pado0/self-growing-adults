package entity

import constant.DB_NULL_ID
import vo.MemberProfileIds
import javax.persistence.*

@Entity

class LearningHistory(


    // 값타입. 값타입을 정의하는 클래스를 VO라고 한다. Embedded

    // 회원 정보 (profile Id, member Id가 MemberProfileIds 클래스에 존재)
    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "memberId", column = Column(name = "member_id", nullable = false)),
        AttributeOverride(name = "profileId", column = Column(name = "profile_id", nullable = false)),
    ) // VO 내 컬럼명이 중복되므로 매핑정보 재정의
    var memberProfileIds: MemberProfileIds

    // 컨텐츠 구분 (ActType, ContentType)
    // ContentClassification VO

    // Enum. Enumerated
    // 학습 이력 구분, COMPLETED

    // 학습시간, Second



) {
    @Id
    val id: Long = DB_NULL_ID
}