package com.koje.brickgame.core

import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Position

class MarbleSource : ImageComponent(Playground) {

    val position = Position(0f, 0.075f)
    var creation: Marble? = null
    var inventory = 99

    init {
        Playground.addComponent(this)

        image = Playground.picmap
        index = 2
        count = 100
        plane = 2

        addProcedure {
            move(position)
            scale(0.05f)
            build()
        }

    }

    fun build() {
        if (creation == null && inventory > 0) {
            inventory--
            Playground.counter.setValue(inventory)
            creation = Marble()
        }

    }

}