package com.pado.domain.repository

import com.pado.domain.entity.LearningScore
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface LearningScoreRepository : JpaRepository<LearningScore, Long> {
}