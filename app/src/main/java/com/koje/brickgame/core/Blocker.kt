package com.koje.brickgame.core

import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Position

class Blocker : ImageComponent(Playground) {

    val position = Position(0f, 0.62f)
    var targetX = 0f
    val speed = 0.0007f

    init {
        image = Playground.picmap
        index = 10
        count = 100
        plane = 2

        addProcedure {
            if (position.x < targetX) {
                position.x = (position.x + speed * Playground.loopTime).coerceAtMost(targetX)
            }
            if (position.x > targetX) {
                position.x = (position.x - speed * Playground.loopTime).coerceAtLeast(targetX)
            }
            move(position)
            scale(0.4f)
        }

    }

    fun blocked(x: Float): Boolean {
        if (x < position.x - 0.2f) return false
        if (x > position.x + 0.2f) return false
        return true
    }

}