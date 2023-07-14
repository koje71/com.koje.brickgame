package com.koje.brickgame.core.boards

import com.koje.brickgame.core.Playground
import com.koje.brickgame.core.stones.Stone
import com.koje.framework.graphics.ComponentGroup

open class Board : ComponentGroup(Playground){

    val stones = mutableListOf<Stone>()

    init{
        plane = 2
    }
}