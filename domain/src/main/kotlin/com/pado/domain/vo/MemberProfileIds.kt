package com.pado.domain.vo

import javax.persistence.Embeddable

@Embeddable
data class MemberProfileIds(

    /**
     * 회원 id : Member Entity auto increment id
     */
    var memberId: Long,

    /**
     * 프로필 id : Profile Entity auto increment id
     */
    var profileId: Long,
){
    companion object{
        fun of(
            memberId: Long,
            profileId: Long,
        ) =MemberProfileIds(
            memberId = memberId,
            profileId = profileId
        )
    }
}