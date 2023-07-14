package com.koje.brickgame.core.boards

import com.koje.brickgame.core.stones.Stone2

class Board01:Board() {

    init{
        stones.add(Stone2(this).withPosition(0f,1f))
    }


}