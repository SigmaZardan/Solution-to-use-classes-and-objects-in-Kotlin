package com.bibek.learningkotlin

fun main() {

  val price = calculateMovieTicketPrice(189,true)
    println(price)

}

fun calculateMovieTicketPrice( age : Int , isMonday : Boolean) : String {


    while(age < 100 )  {

        if(age <= 12 ) {
            return "Just pay $15"
        }

        else if( age <=60 ) {

            return  if(isMonday) {
                "Just pay $25 for the ticket because it is 5$ discount on Monday"
            }
            else {
                "A standard ticket price of $30"
            }

        }

        else {
            return "Senior ticket price of $20"
        }

    }
    return "-1"



}

// this is the code snippet for the function given in the question

fun ticketPrice( age : Int , isMonday : Boolean ) : Int {


    while( age < 100 ) {

         if( age <= 12 ) {

             return 15;
         }

         else if( age <= 60) {

             return if( isMonday ) 25 else 30
         }

        else {
            return 20
         }
    }
    return -1

}

//solution in the Practice section

fun ticketPrice2( age : Int , isMonday : Boolean ) : Int {

    return when(age ) {
          in 0..12 -> 15
          in 13..60 -> if(isMonday) 25 else 30
          in 61..100 -> 20
        else -> -1

    }

}
