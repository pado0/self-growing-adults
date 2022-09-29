package repository

import entity.LearningScore
import org.springframework.data.jpa.repository.JpaRepository

interface LearningScoreRepository : JpaRepository<LearningScore, Long> {
}