package com.koje.brickgame.core

import com.koje.brickgame.core.boards.Board
import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Position
import kotlin.random.Random

class Target(val board: Board) : ComponentGroup(Playground) {

    val position = Position(0f, 0.3f)
    var animation = 1f * Random.nextInt(320)
    var angle = 0f
    var size = -1f

    init {
        addImageComponent {
            image = Playground.picmap
            index = 0
            count = 100
            plane = 2

            addProcedure {
                move(position)
                rotate(angle)

                animation += 0.3f * surface.loopTime
                if (animation > 360f) {
                    animation -= 360f
                }

                if (size < 0f) {
                    size = 0.5f + position.distanceTo(board.marbleSource.position)
                }

                scale(size * 0.17f + 0.01f * sin(animation))
            }
        }

    }


    fun onTouch(touch: Position) {
        position.copyFrom(touch)

        val deltaX = board.marbleSource.position.x - position.x
        val deltaY = board.marbleSource.position.y - position.y
        angle = 180 + Math.toDegrees(kotlin.math.atan2(deltaX, deltaY).toDouble()).toFloat()

        size = 0.5f + position.distanceTo(board.marbleSource.position)
    }

}