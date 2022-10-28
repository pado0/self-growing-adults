package com.pado.domain.entity

import com.pado.domain.constant.DB_NULL_ID
import org.hibernate.annotations.Type
import com.pado.domain.type.ScoreType
import org.springframework.data.annotation.CreatedDate
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "learning_score")
class LearningScore(

    @Enumerated(EnumType.STRING)
    @Column(name = "score_type")
    val scoreType: ScoreType,

    @Lob
    @Column(name = "score_data", nullable = false, columnDefinition = "TEXT")
    // @Type(type = "org.hibernate.type.TextType") // 이전에 오류가 나서 타입추가 했었는데, 일단 지워두기
    val scoreData: String,


    // LearningHistory와 다대일 단방향 연관관계 맵핑
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "learning_history_id", referencedColumnName = "id", nullable = false, updatable = false) // learningHistory 엔티티쪽의 id 컬럼을 참조하고, Update는 못하도록 막는다.
    val learningHistory: LearningHistory,

    ) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = DB_NULL_ID

    @CreatedDate
    var createdAt: Instant = Instant.now()
        protected set
}