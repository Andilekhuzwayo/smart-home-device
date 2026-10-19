open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"

    open fun turnOn() {
         println("Smart device is turned on")
     }
    open fun turnOff() {
        println("Smart device is turned off")
    }
}

// inheritance
class SmartTvDevice(deviceNAme: String, deviceCategory: String) :
    SmartDevice(name = deviceNAme, category =  deviceCategory) {

    var speakerVolume = 2
        set(value) {
            if(value in 0..100) {
                field = value
            }
        }

    var channelNmber = 5
        set(value) {
            if(value in 0..200) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("speaker volume inceased my $speakerVolume")
    }

    fun changeChannel() {
        channelNmber++
        println("channel has been changed to $channelNmber")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory) {
    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    fun increaseBrightness() {
        brightnessLevel++
        println("brightness increased to $brightnessLevel")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    fun turnOnTv(){
        smartTvDevice.turnOn()
    }

    fun turnOffTv(){
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume(){
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeChannelToNext(){
        smartTvDevice.changeChannel()
    }

    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }
}

fun main() {
    val smartTvDevie = SmartDevice(name = "andriodTv", category = "Entertainment")
    smartTvDevie.turnOn()
    smartTvDevie.turnOff()
}