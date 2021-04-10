import com.soywiz.korge.view.SpriteAnimation
import com.soywiz.korim.format.readBitmapSlice
import com.soywiz.korio.file.std.resourcesVfs
import kotlinx.coroutines.flow.flow

object Animations {

    object Player {

        sealed class Motion {
            object Idle : Motion()
            object Left : Motion()
            object Right : Motion()
            object Up : Motion()
            object Down : Motion()
        }

        object Gary {

            val assetPaths = mutableMapOf<Motion, List</*assetPath*/String>>().apply {
                put(Motion.Idle, listOf("player/gary/walk/idle/font01_a.png"))
                put(
                    Motion.Left, listOf(
                        "player/gary/walk/left/font11_0.png",
                        "player/gary/walk/left/font12_0.png",
                        "player/gary/walk/left/font13_0.png"
                    )
                )
                put(
                    Motion.Right, listOf(
                        "player/gary/walk/left/font11_0.png",
                        "player/gary/walk/left/font12_0.png",
                        "player/gary/walk/left/font13_0.png"
                    )
                )
                put(
                    Motion.Up, listOf(
                        "player/gary/walk/up/font04_d.png",
                        "player/gary/walk/up/font05_e.png",
                        "player/gary/walk/up/font06_f.png"
                    )
                )
                put(
                    Motion.Down, listOf(
                        "player/gary/walk/down/font01_a.png",
                        "player/gary/walk/down/font02_b.png",
                        "player/gary/walk/down/font03_c.png"
                    )
                )
            }

            val spriteAnimations = flow {
                val animations = assetPaths.map { (key, value) ->
                    key to SpriteAnimation(value.map { resourcesVfs[it].readBitmapSlice() })
                }
                emit(animations.toMap())
            }

        }

    }


}