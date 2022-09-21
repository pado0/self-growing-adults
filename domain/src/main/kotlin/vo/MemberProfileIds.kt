package vo

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
)