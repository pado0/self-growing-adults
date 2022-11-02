package com.pado.api.service

import com.pado.domain.service.LearningHistoryDomainCommandService

class StatelessTestService(
private val learningHistoryDomainCommandService: LearningHistoryDomainCommandService, // state variable이 아닌 db 값 자체에 접근한다. Price 관련 레퍼지토리 참고
) {

    fun order(name:String, price: Int){
        // learningHistoryDomainCommandService.create( price 관련 값)
        // println("name, price = $n")
    }
}