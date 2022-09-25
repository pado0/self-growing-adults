package repository

import entity.LearningHistory
import org.springframework.data.jpa.repository.JpaRepository

interface LearningHistoryRepository : JpaRepository<LearningHistory, Long>{
}