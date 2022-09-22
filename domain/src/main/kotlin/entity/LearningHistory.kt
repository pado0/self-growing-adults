package entity

import constant.DB_NULL_ID
import vo.MemberProfileIds
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