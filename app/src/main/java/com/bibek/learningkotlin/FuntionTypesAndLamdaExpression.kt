package com.bibek.learningkotlin

fun main(){


    val treatFunction = trickOrTreat(false ,   ) {  "$it  quarters "} // this is the trailing lamda expression
    // it is passed as the argument in the treatFunction
    val trickFunction = trickOrTreat(true , null)


    repeat(5  ) {
        treatFunction()
    }
    trickFunction()




}
val trick = {
    println("No treats! ")
}


val treat  = {
    println("Have a treat!")
}

//val coins : (Int) -> String = {
//      //  quantity -> "$quantity quarters"
//    "$it quarters "
//
//}

val cupCake : (Int) -> String = {
                "Have a cupcake!"
}

// this is an example of higher order function


fun trickOrTreat( isTrick : Boolean ,extraTreat : ((Int) -> String)? ) : () -> Unit{



   if(isTrick){
       return trick
   }
   else {
       if(extraTreat != null) {
           println(extraTreat(5))
       }
       return treat
   }



}


