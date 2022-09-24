package entity

import constant.DB_NULL_ID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class LearningScore(



    // LearningHistory와 다대일 단방향 연관관계 맵핑

) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = DB_NULL_ID
}