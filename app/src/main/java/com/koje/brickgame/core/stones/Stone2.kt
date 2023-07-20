package com.koje.brickgame.core.stones

import com.koje.brickgame.R
import com.koje.brickgame.core.Counter
import com.koje.brickgame.core.Names
import com.koje.brickgame.core.Playground
import com.koje.brickgame.core.boards.Board

class Stone2(val board: Board) : Stone(board) {

    var bumps = 9
    val counter = Counter(-0.0f, 0f, 0.3f)

    init {
        addComponent(counter)
        counter.setValue(bumps)
        counter.setColor(R.color.white)

        addImageComponent {
            image = Playground.picmap
            count = 400
            index = 100

            addProcedure {
                index = imageIndex1
            }
        }

        addImageComponent {
            image = Playground.picmap
            count = 400
            index = 102

            addProcedure {
                index = imageIndex3
                move(1f, 0f)
            }
        }

        addImageComponent {
            image = Playground.picmap
            count = 400
            index = 42

            addProcedure {
                scale(0.4f)
                move(1.2f, 0f)
            }
        }
    }

    override fun cornerBottomLeftX(): Float {
        return position.x - 0.06f
    }

    override fun cornerBottomLeftY(): Float {
        return position.y - 0.06f
    }

    override fun cornerTopRightX(): Float {
        return position.x + 0.06f + 0.05f
    }

    override fun CornerTopRightY(): Float {
        return position.y + 0.06f
    }

    override fun onPitch() {
        super.onPitch()
        bumps--
        if (bumps == 0) {
            death = true
        }
        counter.setValue(bumps)
    }

}