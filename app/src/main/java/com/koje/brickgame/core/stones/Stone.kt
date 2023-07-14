package com.koje.brickgame.core.stones

import com.koje.brickgame.core.Marble
import com.koje.brickgame.core.Playground
import com.koje.brickgame.core.boards.Board
import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position

open class Stone(board: Board): ComponentGroup(Playground) {

    val position= Position()
    val cornerUL = Position()
    val cornerTR = Position()


    init{
        board.addComponent(this)
        plane = 3

        addProcedure {
            move(position)
            scale(0.1f)
        }
    }

    fun withPosition(x:Float,y:Float):Stone{
        position.set(x,y)
        calculate()
        return this
    }

    fun onPitch(){

    }

    fun checkCollision(marble: Marble){
        if(marble.position.x  < cornerUL.x) return
        if(marble.position.x  > cornerTR.x) return
        if(marble.position.y  < cornerUL.y) return
        if(marble.position.y  > cornerTR.y) return

        if(marble.passedX(cornerUL.x) || marble.passedX(cornerTR.x)){
            marble.vector.x *= -1
            marble.movingX()
        }

        if(marble.passedY(cornerUL.y) || marble.passedY(cornerTR.y)){
            marble.vector.y *= -1
            marble.movingY()
        }


    }

    open fun calculate(){

    }
}