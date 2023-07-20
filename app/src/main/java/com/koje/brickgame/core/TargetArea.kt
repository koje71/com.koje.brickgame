package com.koje.brickgame.core

import com.koje.brickgame.core.boards.Board
import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Position
import kotlin.random.Random

class TargetArea(val board: Board) : ComponentGroup(Playground) {

    val position = Position()
    val yMax = 0.44f
    val yMin = 0.16f

    val angleCounter = Counter(-0.43f, 0.37f, 0.03f)
    val speedCounter = Counter(-0.43f, 0.33f, 0.03f)

    init {
        angleCounter.setValue(0)
        speedCounter.setValue(0)

        addImageComponent {
            image = Playground.picmap
            index = 1
            count = 100
            plane = 2

            addProcedure {
                move(0f, 0.3f)
                scale(1.5f, 0.3f)
            }
        }

        addImageComponent {
            image = Playground.picmap
            index = 43
            count = 400

            addProcedure {
                move(-0.47f, 0.37f)
                scale(0.03f)
            }
        }

        addImageComponent {
            image = Playground.picmap
            index = 63
            count = 400

            addProcedure {
                move(-0.47f, 0.33f)
                scale(0.03f)
            }
        }

        addComponent(angleCounter)
        addComponent(speedCounter)

        addProcedure {
            var angle = board.target.angle
            if (angle > 90) {
                angle -= 360f
            }
            val text = "$angle".replace('.', ',')

            angleCounter.setValue("$angle".replace('.', ','))

            var speed = board.target.position.distanceTo(board.marbleSource.position) * 30
            speedCounter.setValue("$speed".replace('.', ','))
        }
    }
}