import com.soywiz.korge.Korge
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import com.soywiz.korui.layout.MathEx

suspend fun main() = Korge(
        title = "Korge_Sample",
        width = 480,
        height = 640,
        bgcolor = RGBA(253, 247, 240) //Colors["#2b2b2b"]
) {


    val top = roundRect(views.virtualWidth, 1, 0, 0, Colors.BLACK) {
        position(0, 10)
        addChild(this)
    }

    val bottom = roundRect(views.virtualWidth, 1, 0, 0, Colors.BLACK) {
        position(0, views.virtualHeight - 10)
        addChild(this)
    }

    val left = roundRect(1, views.virtualHeight, 0, 0, Colors.BLACK) {
        position(10, 0)
        addChild(this)
    }

    val right = roundRect(1, views.virtualHeight, 0, 0, Colors.BLACK) {
        position(views.virtualWidth - 10, 0)
        addChild(this)
    }


    val roundView = roundRect(100, 100, 100, 100, Colors.PINK) {
        position(views.virtualWidth / 2, views.virtualWidth / 2)
        addChild(this)
    }

    roundRect(100, 100, 100, 100, Colors.GREEN) {
        addChild(this)
        alignRightToLeftOf(roundView,padding = 5)
        alignBottomToBottomOf(roundView)
    }


}