package com.koje.brickgame.core

import com.koje.brickgame.R
import com.koje.brickgame.core.boards.Board
import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Position

class MarbleSource(val board: Board) : ComponentGroup(Playground) {

    val position = Position(0f, 0.075f)
    var creation: Marble? = null
    var inventory = 99
    val counter = Counter(0.07f, 0.075f, 0.05f)

    init {
        addComponent(counter)
        addImageComponent {
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

        addComponent(counter)
    }

    fun build() {
        if (creation == null && inventory > 0) {
            inventory--
            counter.setValue(inventory)
            creation = Marble(board)
        }

    }

}