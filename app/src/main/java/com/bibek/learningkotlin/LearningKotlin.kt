package com.bibek.learningkotlin

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice( val name : String , val category : String ) {
    var deviceStatus = "unknown "
//     protected set(value){
//         field = value
//     }
     // since the above method is internally carried by the kotlin compiler itself
        // we can write the below coed to define a set method as protected
     protected set


     open val deviceType = "unknown"

    constructor( name : String, category : String , statusCode : Int) : this( name , category){

           deviceStatus = when(statusCode ) {
                 0 -> "off "
                 1 -> "on"
                 else -> "unknown"
           }
    }

  open  fun turnOn(){
        deviceStatus  = "online"

    }

   open fun turnOff(){
        deviceStatus =  "offline"

    }

    open fun printDeviceInfo(){
        println("Device name : $name , Device category : $category , Device type : $deviceType")
    }


}
// we can say that smart tv device is a smart device
class SmartTvDevice( deviceName : String , deviceCategory : String ) :
    SmartDevice(name = deviceName , category = deviceCategory) {

       private var speakerVolume by RangeRegulator(0,0,100)

       private var channelNumber by RangeRegulator(1,0,200)
      override val deviceType = "Smart TV"



       fun increaseSpeakerVolume(){
           speakerVolume++
           println("Speaker volume is increased to $speakerVolume")


       }
      fun decreaseSpeakerVolume(){
        speakerVolume--
        println("Speaker volume is decreased to $speakerVolume")
      }

       fun nextChannel(){
           channelNumber++
           println("The channel number is increased to $channelNumber")
       }

      fun previousChannel(){
          channelNumber--
          println("The channel number is decreased to $channelNumber")
      }
     override fun turnOn(){
          super.turnOn()
         println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber")

    }

    override fun turnOff(){
        super.turnOff()
        println("Smart tv is turned off")
    }


}

// we can say that smart light device is a smart device
class SmartLightDevice(deviceName : String , deviceCategory : String ) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light "

      private  var brightnessLevel by RangeRegulator(0,0,100)

      fun increaseBrightness(){
          brightnessLevel++
          println("The brightness is increased to $brightnessLevel")
      }
    fun decreaseBrightness(){
        brightnessLevel--
        println("The brightness is decreased to $brightnessLevel")
    }

    override fun turnOn(){
        super.turnOn()
        brightnessLevel = 2
        println("$name is turned on and its brightness is $brightnessLevel")
    }

    override fun turnOff(){
        super.turnOff()
        brightnessLevel = 0
        println("Smart light turned off")
    }

}

class SmartHome(
    val smartTvDevice : SmartTvDevice,
    val smartLightDevice : SmartLightDevice
) {

    var deviceTurnOnCount = 0
   private set




    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }
    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

  fun check() : Boolean = deviceTurnOnCount > 0




    fun turnOffTv() {
             if(check()) {
                 deviceTurnOnCount--
                 smartTvDevice.turnOff()
             }

    }


    fun increaseTvVolume() {
        if(check()) {

            smartTvDevice.increaseSpeakerVolume()
        }
    }

    fun changeTvChannelToNext() {
        if(check()) {
            smartTvDevice.nextChannel()
        }
    }


    fun turnOffLight() {
        if(check()) {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }

    }

    fun increaseLightBrightness() {
        if(check()) {
            smartLightDevice.increaseBrightness()
        }
    }

    fun turnOffAllDevices() {
        if(check()) {
            turnOffTv()
            turnOffLight()
        }
    }


    fun decreaseTvVolume() {
        if(check()) {
           smartTvDevice.decreaseSpeakerVolume()
        }

    }
    fun changeTvChannelToPrevious() {
        if(check()) {
            smartTvDevice.previousChannel()
        }
    }

    fun decreaseLightBrightness() {
        if(check()) {
            smartLightDevice.decreaseBrightness()

        }
    }

    fun printSmartTvInfo() {
        if(check()){
            smartTvDevice.printDeviceInfo()
        }

    }

    fun printSmartLightInfo() {
        if(check()){
            smartLightDevice.printDeviceInfo()
        }

    }

}



class RangeRegulator(
   initialValue : Int ,
   private val minValue : Int ,
   private val maxValue : Int

)  : ReadWriteProperty<Any?, Int> {

     private var fieldData = initialValue

    override fun getValue(thisRef : Any? , property : KProperty<*>) : Int {
             return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
                  if(value in minValue .. maxValue) fieldData = value
    }

}



fun main() {
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = " Google Light", deviceCategory = "Utility")
    )


    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.increaseLightBrightness()
    println()

    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()
    println()


    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()
    smartHome.decreaseLightBrightness()
    println()

    smartHome.turnOffAllDevices()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}" )
}