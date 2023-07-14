package com.koje.brickgame.core

import com.koje.framework.graphics.ImageComponent

class Background : ImageComponent(Playground) {

    init {
        image = Playground.background
        index = 0
        count = 1

        addProcedure {
            move(0f, Playground.ratio / 2f)
            scale(
                when (Playground.ratio < 1.4f) {
                    true -> 1.4f
                    else -> Playground.ratio
                }
            )
        }
    }
}