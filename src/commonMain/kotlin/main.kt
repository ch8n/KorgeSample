import com.soywiz.klock.timesPerSecond
import com.soywiz.korev.Key
import com.soywiz.korge.Korge
import com.soywiz.korge.view.*
import com.soywiz.korge.view.camera.cameraContainer
import com.soywiz.korgw.GameWindow
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import module.main.AppModule

suspend fun main() = Korge(Korge.Config(module = AppModule))

//suspend fun main() = Korge(
//        quality = GameWindow.Quality.PERFORMANCE,
//        title = "Korge_Sample",
//        width = 480,
//        height = 640,
//        bgcolor = RGBA(253, 247, 240) //Colors["#2b2b2b"]
//) {
//
//    val height = views.virtualHeight
//    val width = views.virtualWidth
//
//    val cam = camera()
//    cameraContainer(200.0,200.0){
//
//    }
//
//
//    val player = circle(radius = 25.0, fill = Colors.PINK).xy(height / 2, width / 2)
//    val leftText = text(text = "left", textSize = 100.0, color = Colors.RED).xy(100, 100)
//
//    val rightText = text(text = "right", textSize = 100.0, color = Colors.BLUE).xy(leftText.x, 100 + leftText.y)
//
//    val upText = text(text = "up", textSize = 100.0, color = Colors.GREEN).xy(rightText.x, 100 + rightText.y)
//    val downText = text(text = "down", textSize = 100.0, color = Colors.AQUA).xy(upText.x, 100 + upText.y)
//
//
//    addFixedUpdater(60.timesPerSecond) {
//
//        player.onCollision({ it == leftText }) {
//            player.color = Colors.BLACK
//            leftText.text = "BANG!"
//        }
//
//        when {
//
//            views.input.keys[Key.UP] && views.input.keys[Key.LEFT] -> {
//                player.color = Colors.BLUEVIOLET
//                player.xy(player.x - 1, player.y - 1)
//            }
//
//            views.input.keys[Key.UP] && views.input.keys[Key.RIGHT] -> {
//                player.color = Colors.GREENYELLOW
//                player.xy(player.x + 1, player.y - 1)
//            }
//
//            views.input.keys[Key.DOWN] && views.input.keys[Key.RIGHT] -> {
//                player.color = Colors.HOTPINK
//                player.xy(player.x + 1, player.y + 1)
//            }
//
//            views.input.keys[Key.DOWN] && views.input.keys[Key.LEFT] -> {
//                player.color = Colors.TAN
//                player.xy(player.x - 1, player.y + 1)
//            }
//
//            views.input.keys[Key.UP] -> {
//                player.color = upText.color
//                player.y -= 1
//            }
//            views.input.keys[Key.DOWN] -> {
//                player.color = downText.color
//                player.y += 1
//            }
//            views.input.keys[Key.LEFT] -> {
//                player.color = leftText.color
//                player.x -= 1
//            }
//            views.input.keys[Key.RIGHT] -> {
//                player.color = rightText.color
//                player.x += 1
//            }
//            else -> player.color = Colors.PINK
//        }
//    }
//
//}