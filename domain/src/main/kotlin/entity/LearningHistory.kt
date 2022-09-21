package entity

import constant.DB_NULL_ID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class LearningHistory(


    // 값타입. 값타입을 정의하는 클래스를 VO라고 한다. Embedded

    // 회원 정보 (profile Id, member Id)
    // memberProfileId VO

    // 컨텐츠 구분 (ActType, ContentType)
    // ContentClassification VO

    // Enum. Enumerated
    // 학습 이력 구분, COMPLETED

    // 학습시간, Second



) {
    @Id
    val id: Long = DB_NULL_ID
}