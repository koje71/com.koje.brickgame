package com.koje.brickgame.core

import com.koje.brickgame.R
import com.koje.brickgame.core.boards.Board01
import com.koje.brickgame.core.stones.Stone
import com.koje.framework.graphics.Position
import com.koje.framework.graphics.Surface

object Playground : Surface() {

    val background = createImageDrawer(R.drawable.background2)
    val picmap = createImageDrawer(R.drawable.picmap)


    val marbleSource = MarbleSource()
    val target = Target()
    val targetArea = TargetArea()
    val blocker = Blocker()
    val counter = Counter(0.07f, 0.075f, 0.05f)

    val currentBoard = Board01()

    init {
        addComponent(Background())
        addComponent(currentBoard)
    }

    override fun onTouch(touch: Position, action: Int) {
        touch.y = Math.max(touch.y, targetArea.yMin)
        touch.y = Math.min(touch.y, targetArea.yMax)
        target.position.copyFrom(touch)
        blocker.targetX = touch.x
    }

}