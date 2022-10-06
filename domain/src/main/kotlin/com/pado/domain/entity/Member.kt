package com.pado.domain.entity

import com.pado.domain.constant.DB_NULL_ID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(
    var phoneNumber: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = DB_NULL_ID
}