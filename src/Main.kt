open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
    open  val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
     }
    open fun turnOff() {
        deviceStatus = "off"

    }
}

// inheritance of the smartDevice superclass
class SmartTvDevice(deviceNAme: String, deviceCategory: String) :
    SmartDevice(name = deviceNAme, category =  deviceCategory) {

    override val deviceType = "Smart Tv"
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
        println("channel has been changed to $channelNmber.")
    }

    override fun turnOn() {
        super.turnOn()
        print("$name is turned on. The volume is set to $speakerVolume and channel number is $channelNmber. \n")
    }

    override fun turnOff() {
        super.turnOff()
        print("$name turned off. ")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart Light"
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

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level $brightnessLevel. ")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("smart light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    fun turnOnTv() {
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeChannelToNext() {
        smartTvDevice.changeChannel()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }
}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("andriodTv","Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google light","Utility")
    smartDevice.turnOn()
}