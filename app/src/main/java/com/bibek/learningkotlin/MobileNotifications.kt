package com.bibek.learningkotlin

fun main(){


    println(printNotificationSummary(100))

}

fun printNotificationSummary(numberOfMessages : Int) {

       if( numberOfMessages >= 100 ) {
           println("You phone is blowing up! You have 99+ notifications")
       }
    else { println("You have $numberOfMessages notifications.")

       }

}