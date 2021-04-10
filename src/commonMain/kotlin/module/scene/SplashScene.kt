package module.scene

import com.soywiz.klock.timesPerSecond
import com.soywiz.korev.Key
import com.soywiz.korge.input.onClick
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.scene.sceneContainer
import com.soywiz.korge.ui.uiTextButton
import com.soywiz.korge.view.*
import com.soywiz.korio.async.launchImmediately
import Animations.Player.Gary
import Animations.Player.Motion
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.single


class GameScene : Scene() {

    override suspend fun Container.sceneInit(): Unit {
        sceneContainer(name = "game", views = views) {

            val animations = Gary.spriteAnimations.single()
            val animIdle = requireNotNull(animations[Motion.Idle])
            val animWalkLeft = requireNotNull(animations[Motion.Left])
            val animWalkRight = requireNotNull(animations[Motion.Right])
            val animWalkUp = requireNotNull(animations[Motion.Up])
            val animWalkDown = requireNotNull(animations[Motion.Down])

            val mainText = text(text = "Big-Brain-Time", textSize = 32.toDouble()).centerOnStage()

            val player = sprite(initialAnimation = animIdle) {
                centerOnStage()
                playAnimationLooped()
                alignTopToBottomOf(mainText)
                alignLeftToLeftOf(mainText)
                alignRightToRightOf(mainText)
            }

            addFixedUpdater(60.timesPerSecond) {

                when {

                    views.input.keys[Key.UP] && views.input.keys[Key.LEFT] -> {
                        player.playAnimationLooped(spriteAnimation = animWalkLeft)
                        player.xy(player.x - 1, player.y - 1)
                    }

                    views.input.keys[Key.UP] && views.input.keys[Key.RIGHT] -> {
                        player.playAnimationLooped(spriteAnimation = animWalkRight)
                        player.xy(player.x + 1, player.y - 1)
                    }

                    views.input.keys[Key.DOWN] && views.input.keys[Key.RIGHT] -> {
                        player.playAnimationLooped(spriteAnimation = animWalkDown)
                        player.xy(player.x + 1, player.y + 1)
                    }

                    views.input.keys[Key.DOWN] && views.input.keys[Key.LEFT] -> {
                        player.playAnimationLooped(spriteAnimation = animWalkDown)
                        player.xy(player.x - 1, player.y + 1)
                    }

                    views.input.keys[Key.UP] -> {
                        player.playAnimationLooped(spriteAnimation = animWalkUp)
                        player.y -= 1
                    }
                    views.input.keys[Key.DOWN] -> {
                        player.playAnimationLooped(spriteAnimation = animWalkDown)
                        player.y += 1
                    }
                    views.input.keys[Key.LEFT] -> {
                        player.playAnimationLooped(spriteAnimation = animWalkLeft)
                        player.x -= 1
                    }
                    views.input.keys[Key.RIGHT] -> {
                        player.playAnimationLooped(spriteAnimation = animWalkRight)
                        player.x += 1
                    }
                    else -> player.playAnimationLooped(spriteAnimation = animIdle)
                }
            }
        }
    }
}