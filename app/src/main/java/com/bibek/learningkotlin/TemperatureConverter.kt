package com.bibek.learningkotlin


fun main() {

    printFinalTemperature(
        27.0 ,
        "Celsius" ,
        "Fahrenheit" , ) {
        (9.0/5.0) * it + 32
    }


    printFinalTemperature(
        350.0,
        initialUnit = "Kelvin",
        finalUnit = "Celsius" ,

    ) {
        it - 273.15
    }

    printFinalTemperature(
        initialMeasurement = 10.0,
        initialUnit = "Fahrenheit" ,
        finalUnit = "Kelvin" ,

    ) {
        (5.0 / 9.0) * (it - 32 ) + 32

    }


}

fun printFinalTemperature(
    initialMeasurement : Double ,
    initialUnit : String ,
    finalUnit : String ,
    conversionFormula : (Double ) -> Double


) {

    val finalMeasurement = String.format("%.2f" , conversionFormula(initialMeasurement))
    println(" $initialMeasurement degrees $initialUnit to $finalUnit is $finalMeasurement")



}



