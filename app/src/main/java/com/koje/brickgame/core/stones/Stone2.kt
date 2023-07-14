package com.koje.brickgame.core.stones

import com.koje.brickgame.core.Playground
import com.koje.brickgame.core.boards.Board

class Stone2(board: Board) : Stone(board) {


    init {
        board.addImageComponent {
            image = Playground.picmap
            count = 100
            index = 0

            addProcedure {
                move(cornerUL)
                scale(0.1f)
            }
        }

        board.addImageComponent {
            image = Playground.picmap
            count = 100
            index = 0

            addProcedure {
                move(cornerTR)
                scale(0.1f)
            }
        }

        addImageComponent {
            image = Playground.picmap
            count = 400
            index = 100
        }

        addImageComponent {
            image = Playground.picmap
            count = 400
            index = 102

            addProcedure {
                move(1f,0f)
            }
        }

    }

    override fun calculate() {
        super.calculate()
        cornerUL.set(position.x - 0.06f, position.y - 0.06f)
        cornerTR.set(position.x + 0.06f + 0.05f, position.y + 0.06f)
    }


}