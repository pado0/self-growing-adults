package vo

import javax.persistence.Embeddable

@Embeddable
inline class Second(
    private val value: Int,
)