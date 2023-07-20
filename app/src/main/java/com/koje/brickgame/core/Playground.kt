package com.koje.brickgame.core

import com.koje.brickgame.R
import com.koje.brickgame.core.boards.Board01
import com.koje.brickgame.core.stones.Stone
import com.koje.framework.graphics.Position
import com.koje.framework.graphics.Surface

object Playground : Surface() {

    val background = createImageDrawer(R.drawable.background2)
    val picmap = createImageDrawer(R.drawable.picmap)

    val currentBoard = Board01()

    init {
        addComponent(Background())
        addComponent(currentBoard)
    }

    override fun onTouch(touch: Position, action: Int) {
        currentBoard.onTouch(touch, action)
    }

}