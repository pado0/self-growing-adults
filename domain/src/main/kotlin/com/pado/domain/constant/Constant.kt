package com.pado.domain.constant


// val은 런타임에 결정되는 상수라 불완전
// val num = sum(40, 20) 처럼, sum 함수 입력에 따라 바뀔 수 있음
// const val은 완전 불변성을 가지고 있다. 클래스 생성자에 할당될 수 없다.
const val DB_NULL_ID: Long = 0L