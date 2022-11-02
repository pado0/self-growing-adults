package com.pado.api.service

import com.pado.domain.service.LearningHistoryDomainCommandService
import org.springframework.stereotype.Service

@Service
class StatefulTestService  {
    var price: Int = 0 // 이를 val로 선언해서 this.price = price (set) 자체를 막을 수 있다.

    fun order(name:String, price: Int){
        println("name, price = $name , $price")
        this.price = price
    }
}
