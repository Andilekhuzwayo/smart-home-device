import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open  val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
     }
    open fun turnOff() {
        deviceStatus = "off"

    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, device Type: $deviceType")
    }
}

// inheritance of the smartDevice superclass
class SmartTvDevice(deviceNAme: String, deviceCategory: String) :
    SmartDevice(name = deviceNAme, category =  deviceCategory) {

    override val deviceType = "Smart Tv"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNmber by RangeRegulator(initialValue = 5, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("speaker volume inceased by $speakerVolume")
    }

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("speaker volume decreased by $speakerVolume")
    }

    fun changeChannel() {
        channelNmber++
        println("channel has been changed to $channelNmber.")
    }

    fun previousChannel() {
        channelNmber--
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

    private var  brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("brightness increased to $brightnessLevel")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("brightness decreased by $brightnessLevel")
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
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
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

class RangeRegulator(initialValue: Int,
                     private val minValue: Int,
                     private val maxValue: Int
): ReadWriteProperty<Any?, Int> {
    var fieldValue = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldValue
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if(value in minValue..maxValue) {
            fieldValue = value
        }
    }
}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("andriodTv","Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google light","Utility")
    smartDevice.turnOn()
}