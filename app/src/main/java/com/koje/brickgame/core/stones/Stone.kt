package com.koje.brickgame.core.stones

import com.koje.brickgame.core.Marble
import com.koje.brickgame.core.Names
import com.koje.brickgame.core.Playground
import com.koje.brickgame.core.boards.Board
import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position

open class Stone(board: Board) : ComponentGroup(Playground) {

    val position = Position()
    var type = Names.Blue
    var imageIndex1 = 0
    var imageIndex2 = 0
    var imageIndex3 = 0


    open fun cornerBottomLeftX(): Float {
        return 0f
    }

    open fun cornerBottomLeftY(): Float {
        return 0f
    }

    open fun cornerTopRightX(): Float {
        return 0f
    }

    open fun CornerTopRightY(): Float {
        return 0f
    }

    init {
        board.addComponent(this)
        plane = 3

        addProcedure {
            move(position)
            scale(0.095f)
        }
    }

    fun withPosition(x: Int, y: Int): Stone {
        position.set(-0.515f + x * 0.070f, 0.8f + y * 0.095f)
        return this
    }

    fun withBlue(): Stone {
        type = Names.Blue
        imageIndex1 = 140
        imageIndex2 = 141
        imageIndex3 = 142
        return this
    }

    fun withGreen(): Stone {
        type = Names.Green
        imageIndex1 = 120
        imageIndex2 = 121
        imageIndex3 = 122
        return this
    }

    fun withRed(): Stone {
        type = Names.Red
        imageIndex1 = 100
        imageIndex2 = 101
        imageIndex3 = 102
        return this
    }

    open fun onPitch() {

    }

    fun checkCollision(marble: Marble) {
        if (death) return
        if (marble.type != type) return
        if (marble.position.x < cornerBottomLeftX()) return
        if (marble.position.x > cornerTopRightX()) return
        if (marble.position.y < cornerBottomLeftY()) return
        if (marble.position.y > CornerTopRightY()) return

        if (marble.passedX(cornerBottomLeftX()) || marble.passedX(cornerTopRightX())) {
            marble.vector.x *= -1
            marble.movingX()
            onPitch()
        }

        if (marble.passedY(cornerBottomLeftY()) || marble.passedY(CornerTopRightY())) {
            marble.vector.y *= -1
            marble.movingY()
            onPitch()
        }


    }

}