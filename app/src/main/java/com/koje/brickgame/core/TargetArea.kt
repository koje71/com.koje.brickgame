package com.koje.brickgame.core

import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Position
import kotlin.random.Random

class TargetArea : ImageComponent(Playground) {

    val position = Position()
    val yMax = 0.44f
    val yMin = 0.16f

    init {
        Playground.addComponent(this)

        image = Playground.picmap
        index = 1
        count = 100
        plane = 2

        addProcedure {
            move(0f, 0.3f)
            scale(1.5f, 0.3f)
        }

    }
}