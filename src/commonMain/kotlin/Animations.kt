import com.soywiz.korge.view.SpriteAnimation
import com.soywiz.korim.format.readBitmapSlice
import com.soywiz.korio.file.std.resourcesVfs

object Animations {

    object Player {

        object Gary {

            suspend fun getIdleAnim(): SpriteAnimation {
                val bitmap = resourcesVfs["player/gary/walk/idle/font01_a.png"].readBitmapSlice()
                return SpriteAnimation(listOf(bitmap))
            }

            suspend fun getWalkLeftAnim(): SpriteAnimation {
                val bitmap_left_idle = resourcesVfs["player/gary/walk/left/font11_0.png"].readBitmapSlice()
                val bitmap_left_1 = resourcesVfs["player/gary/walk/left/font12_0.png"].readBitmapSlice()
                val bitmap_left_2 = resourcesVfs["player/gary/walk/left/font13_0.png"].readBitmapSlice()
                return SpriteAnimation(listOf(
                        bitmap_left_idle,
                        bitmap_left_1,
                        bitmap_left_idle,
                        bitmap_left_2
                ))
            }

            suspend fun getWalkRightAnim(): SpriteAnimation {
                val bitmap_right_idle = resourcesVfs["player/gary/walk/right/font08_h.png"].readBitmapSlice()
                val bitmap_right_1 = resourcesVfs["player/gary/walk/right/font09_i.png"].readBitmapSlice()
                val bitmap_right_2 = resourcesVfs["player/gary/walk/right/font10_j.png"].readBitmapSlice()
                return SpriteAnimation(listOf(
                        bitmap_right_idle,
                        bitmap_right_1,
                        bitmap_right_idle,
                        bitmap_right_2
                ))
            }


            suspend fun getWalkUpAnim(): SpriteAnimation {
                val bitmap_up_idle = resourcesVfs["player/gary/walk/up/font04_d.png"].readBitmapSlice()
                val bitmap_up_1 = resourcesVfs["player/gary/walk/up/font05_e.png"].readBitmapSlice()
                val bitmap_up_2 = resourcesVfs["player/gary/walk/up/font06_f.png"].readBitmapSlice()
                return SpriteAnimation(listOf(
                        bitmap_up_idle,
                        bitmap_up_1,
                        bitmap_up_idle,
                        bitmap_up_2
                ))
            }

            suspend fun getWalkDownAnim(): SpriteAnimation {
                val bitmap_down_idle = resourcesVfs["player/gary/walk/down/font01_a.png"].readBitmapSlice()
                val bitmap_down_1 = resourcesVfs["player/gary/walk/down/font02_b.png"].readBitmapSlice()
                val bitmap_down_2 = resourcesVfs["player/gary/walk/down/font03_c.png"].readBitmapSlice()
                return SpriteAnimation(listOf(
                        bitmap_down_idle,
                        bitmap_down_1,
                        bitmap_down_idle,
                        bitmap_down_2
                ))
            }

        }

    }


}