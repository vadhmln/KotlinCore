@JvmInline
value class DisplayBrightness(val value: Double)

fun setDisplayBrightness(newDisplayBrightness: DisplayBrightness) {  }

fun callingFunction() {
    val weight: Double = 85.4
    setDisplayBrightness(DisplayBrightness(weight)) //
}