import com.soywiz.korge.view.Sprite
import com.soywiz.korge.view.SpriteAnimation
import com.soywiz.korim.format.readBitmap
import com.soywiz.korim.format.readBitmapImageData
import com.soywiz.korio.file.std.resourcesVfs

object Animations {

    object Player {

        object Gary {

            val walk_left_anim by lazy {
                resourcesVfs["./player/gary/walk/left/font08_h.png"]

            }

        }

    }


}