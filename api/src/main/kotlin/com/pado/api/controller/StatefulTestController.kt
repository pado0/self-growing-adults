package com.pado.api.controller

import com.pado.api.service.StatefulTestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StatefulTestController(
    private val statefulTestService1: StatefulTestService,
    private val statefulTestService2: StatefulTestService,
) {
    @GetMapping("/test")
    fun test(){
        statefulTestService1.order("a", 10000)
        statefulTestService2.order("b", 20000)

        println("a의 price = ${statefulTestService1.price}")
        println("b의 price = ${statefulTestService2.price}")

    }
}