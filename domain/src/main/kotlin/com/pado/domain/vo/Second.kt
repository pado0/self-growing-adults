package com.pado.domain.vo

import javax.persistence.Embeddable

// todo: inline class 사용이 되지 않는 이유
@Embeddable
data class Second(
    private val value: Int,
)