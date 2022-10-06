package com.pado.domain.repository

import com.pado.domain.entity.LearningHistory
import org.springframework.data.jpa.repository.JpaRepository

interface LearningHistoryRepository : JpaRepository<LearningHistory, Long>{
}