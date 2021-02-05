package module.scene

import com.soywiz.klock.timesPerSecond
import com.soywiz.korev.Key
import com.soywiz.korge.input.onClick
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.scene.sceneContainer
import com.soywiz.korge.ui.uiTextButton
import com.soywiz.korge.view.*
import com.soywiz.korio.async.launchImmediately


class SplashScene : Scene() {
    override suspend fun Container.sceneInit(): Unit {
        sceneContainer(name = "splash", views = views) {
            val mainText = text(text = "This is $name scene container").centerOnStage()
            val menuBtn = uiTextButton(text = "change scene") {
                alignTopToBottomOf(mainText)
                alignLeftToLeftOf(mainText)
                onClick {
                    launchImmediately { sceneContainer.changeTo<MainMenuScene>() }
                }
            }

            uiTextButton(text = "go to game scene") {
                alignTopToBottomOf(menuBtn)
                alignLeftToLeftOf(menuBtn)
                onClick {
                    launchImmediately { sceneContainer.changeTo<GameScene>() }
                }
            }
        }
    }
}


class MainMenuScene : Scene() {
    override suspend fun Container.sceneInit(): Unit {
        sceneContainer(name = "main_menu", views = views) {
            val mainText = text(text = "This is $name scene container").centerOnStage()
            uiTextButton(text = "go to game scene") {
                alignTopToBottomOf(mainText)
                alignLeftToLeftOf(mainText)
                onClick {
                    launchImmediately { sceneContainer.changeTo<GameScene>() }
                }
            }
        }
    }
}

class GameScene : Scene() {
    override suspend fun Container.sceneInit(): Unit {
        sceneContainer(name = "game", views = views) {
            val mainText = text(text = "This is $name scene container").centerOnStage()
//            val player = circle(radius = 25.0, fill = Colors.PINK) {
//                alignTopToBottomOf(mainText)
//                alignLeftToLeftOf(mainText)
//                alignRightToRightOf(mainText)
//            }

//            camera() {
//                setTo(player)
//                setSize(200.0, 200.0)
//            }


            val animIdle = Animations.Player.Gary.getIdleAnim()
            val animWalkLeft = Animations.Player.Gary.getWalkLeftAnim()
            val animWalkRight = Animations.Player.Gary.getWalkRightAnim()
            val animWalkUp = Animations.Player.Gary.getWalkUpAnim()
            val animWalkDown = Animations.Player.Gary.getWalkDownAnim()


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