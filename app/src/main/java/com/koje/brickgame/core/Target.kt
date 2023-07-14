package com.koje.brickgame.core

import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Position
import kotlin.random.Random

class Target : ImageComponent(Playground) {

    val position = Position(0f, 0.3f)
    var animation = 1f * Random.nextInt(320)

    init {
        Playground.addComponent(this)

        image = Playground.picmap
        index = 0
        count = 100
        plane = 2

        addProcedure {
            move(position)

            animation += 0.3f * surface.loopTime
            if (animation > 360f) {
                animation -= 360f
            }

            scale(0.17f + 0.01f * sin(animation))
        }

    }
}