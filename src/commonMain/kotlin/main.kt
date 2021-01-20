import com.soywiz.klock.timesPerSecond
import com.soywiz.korev.Key
import com.soywiz.korev.KeyEvent
import com.soywiz.korge.Korge
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import com.soywiz.korim.font.readBitmapFont
import com.soywiz.korio.file.std.resourcesVfs
import com.soywiz.korui.layout.MathEx

suspend fun main() = Korge(
        title = "Korge_Sample",
        width = 480,
        height = 640,
        bgcolor = RGBA(253, 247, 240) //Colors["#2b2b2b"]
) {

    val height = views.virtualHeight
    val width = views.virtualWidth
    val circle = circle(radius = 25.0, fill = Colors.PINK).xy(height / 2, width / 2)
    val leftText = text(text = "LEFT", textSize = 10.0, color = Colors.RED)
    val rightText = text(text = "LEFT", textSize = 10.0, color = Colors.BLUE)
    val upText = text(text = "LEFT", textSize = 10.0, color = Colors.GREEN)
    val downText = text(text = "LEFT", textSize = 10.0, color = Colors.AQUA)


    addFixedUpdater(30.timesPerSecond) {
        when {
            views.input.keys[Key.UP] && views.input.keys[Key.LEFT] -> {
                circle.color = Colors.BLUEVIOLET
                circle.xy(circle.x - 1, circle.y - 1)
            }

            views.input.keys[Key.UP] && views.input.keys[Key.RIGHT] -> {
                circle.color = Colors.GREENYELLOW
                circle.xy(circle.x + 1, circle.y - 1)
            }

            views.input.keys[Key.DOWN] && views.input.keys[Key.RIGHT] -> {
                circle.color = Colors.HOTPINK
                circle.xy(circle.x + 1, circle.y + 1)
            }

            views.input.keys[Key.DOWN] && views.input.keys[Key.LEFT] -> {
                circle.color = Colors.TAN
                circle.xy(circle.x - 1, circle.y + 1)
            }

            views.input.keys[Key.UP] -> {
                circle.color = upText.color
                circle.y -= 1
            }
            views.input.keys[Key.DOWN] -> {
                circle.color = downText.color
                circle.y += 1
            }
            views.input.keys[Key.LEFT] -> {
                circle.color = leftText.color
                circle.x -= 1
            }
            views.input.keys[Key.RIGHT] -> {
                circle.color = rightText.color
                circle.x += 1
            }
            else -> circle.color = Colors.PINK
        }
    }

}