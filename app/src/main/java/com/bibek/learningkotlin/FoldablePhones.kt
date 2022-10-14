package com.bibek.learningkotlin


 open class Phone(var isScreenLightOn : Boolean = false) {

   open fun switchOn() {

        isScreenLightOn = true
    }

   open fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if(isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhones( var isFolded : Boolean ) :
    Phone(){

        override fun switchOn() {
            if(!isFolded) {
                super.switchOn()
            }

        }

     override fun switchOff() {
         if(!isFolded) {
             super.switchOff()
         }
     }

    fun foldPhone() {
        isFolded = true
    }

    fun unfoldPhone() {
        isFolded = false
    }





}



fun main() {

    var foldablePhones = FoldablePhones(true
    )

    foldablePhones.switchOn()
    foldablePhones.checkPhoneScreenLight()

//    foldablePhones.unfoldPhone()

    foldablePhones.switchOn()

    foldablePhones.checkPhoneScreenLight()



}