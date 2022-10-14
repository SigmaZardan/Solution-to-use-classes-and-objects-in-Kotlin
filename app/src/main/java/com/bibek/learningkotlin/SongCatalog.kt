package com.bibek.learningkotlin



class SongCatalog( private val title : String ,
                 private val artist : String ,
                 private val year : Int ,
                  private val count : Int
                 ) {

       var songPlacement = if(count >= 1000) "Popular" else " Unpopular"


    // the following is from the solution
    val isPopular : Boolean
    get() = count >= 1000


    fun displayInformation() {
        println("$title, performed by $artist , was released in $year.")
        println("The song has count of $count and is $songPlacement")
    }








//    A method that prints a song description in this format:
//    "[Title], performed by [artist], was released in [year published]."



}


fun main() {
    val songCatalog = SongCatalog("Anything ", "Anyone" , 1999,123);
    songCatalog.displayInformation()


}
