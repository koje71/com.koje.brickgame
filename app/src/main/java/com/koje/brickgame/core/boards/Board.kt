package com.koje.brickgame.core.boards

import com.koje.brickgame.core.Blocker
import com.koje.brickgame.core.MarbleSource
import com.koje.brickgame.core.Playground
import com.koje.brickgame.core.Target
import com.koje.brickgame.core.TargetArea
import com.koje.brickgame.core.stones.Stone
import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position

open class Board : ComponentGroup(Playground) {

    val stones = ComponentGroup(Playground)
    val marbleSource = MarbleSource(this)
    val targetArea = TargetArea(this)
    val target = Target(this)
    val blocker = Blocker()

    init {
        addComponent(stones){
            var downTime = 0f
            addProcedure {
                downTime += 0.0002f * Playground.loopTime

                if(downTime>1){
                    downTime = 0f
                    components.forEach {
                        if(it is Stone){
                            it.position.y -= 0.0025f
                        }
                    }
                }
            }
        }
        addComponent(marbleSource)
        addComponent(targetArea)
        addComponent(target)
        addComponent(blocker)
    }


    fun onTouch(touch: Position, action: Int) {
        touch.y = Math.max(touch.y, targetArea.yMin)
        touch.y = Math.min(touch.y, targetArea.yMax - 0.1f)
        target.onTouch(touch)
        blocker.targetX = touch.x
    }

    fun addStone(value:Stone){
        stones.components.add(value)
    }
}