package vo

import type.ActType
import type.ContentType
import javax.persistence.Embeddable
import javax.persistence.EnumType
import javax.persistence.Enumerated

// 임베디드 타입 안에 enum 타입을 갖고있는 구조.
// DB엔 각 actType과 contentType이 act_type, content_type 필드에 저장되며 해당 값은 enum을 String 형태로 읽은 것이다.
@Embeddable
data class ContentClassification(
    val contentId: String,

    @Enumerated(EnumType.STRING)
    val actType: ActType,

    @Enumerated(EnumType.STRING)
    val contentType: ContentType,
)