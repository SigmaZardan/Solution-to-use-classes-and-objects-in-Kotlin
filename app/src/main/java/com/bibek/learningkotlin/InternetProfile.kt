package com.bibek.learningkotlin


class Person(val name : String,
             val age : Int ,
             val hobby : String? ,
             val referrer : Person?
             )  {

    fun showProfile() {

        println("Name is $name ," +
                " Age is $age ," +
                " Hobby is ${hobby ?: "Likes to play nothing "},"+
                " ${if(referrer == null) "Does not have a referrer" else "Has a referrer named ${referrer.name} who likes to play ${referrer.hobby}"}"


            // the following lines are from the solutions
//            if(hobby != null) {
//                print("Likes to $hobby. ")
//            }
//            if(referrer != null) {
//                print("Has a referrer named ${referrer.name}")
//                if(referrer.hobby != null) {
//                    print(", who likes to ${referrer.hobby}.")
//                } else {
//                    print(".")
//                }
//            } else {
//                print("Doesn't have a referrer.")
//            }

        )


    }



}




fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()

}