package entity

import constant.DB_NULL_ID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Profile(
    // profile 클래스의 생성자로 선언하여 초기값을 줄 수 있도록
    // 프로필 id로 member를 찾을 수 있도록 단방향 연관관계
    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    var member: Member,

    var profileName: String,

){
    // id는 굳이 생성자에 둘 필요 없다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = DB_NULL_ID

}