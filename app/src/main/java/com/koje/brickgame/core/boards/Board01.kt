package com.koje.brickgame.core.boards

import com.koje.brickgame.core.stones.Stone2

class Board01 : Board() {

    init {
        addStone(Stone2(this).withPosition(1, 1).withBlue())
        addStone(Stone2(this).withPosition(3, 1).withGreen())
        addStone(Stone2(this).withPosition(5, 1).withRed())
        addStone(Stone2(this).withPosition(7, 1).withRed())
        addStone(Stone2(this).withPosition(9, 1).withRed())
        addStone(Stone2(this).withPosition(11, 1).withRed())
        addStone(Stone2(this).withPosition(13, 1).withRed())

        /*
        addStone(Stone2(this).withPosition(2, 2).withBlue())
        addStone(Stone2(this).withPosition(4, 2).withGreen())
        addStone(Stone2(this).withPosition(6, 2).withRed())
        addStone(Stone2(this).withPosition(8, 2).withRed())
        addStone(Stone2(this).withPosition(10, 2).withRed())
        addStone(Stone2(this).withPosition(12, 2).withRed())

        addStone(Stone2(this).withPosition(1, 3).withBlue())
        addStone(Stone2(this).withPosition(3, 3).withGreen())
        addStone(Stone2(this).withPosition(5, 3).withRed())
        addStone(Stone2(this).withPosition(7, 3).withRed())
        addStone(Stone2(this).withPosition(9, 3).withRed())
        addStone(Stone2(this).withPosition(11, 3).withRed())
        addStone(Stone2(this).withPosition(13, 3).withRed())

        addStone(Stone2(this).withPosition(2, 4).withBlue())
        addStone(Stone2(this).withPosition(4, 4).withGreen())
        addStone(Stone2(this).withPosition(6, 4).withRed())
        addStone(Stone2(this).withPosition(8, 4).withRed())
        addStone(Stone2(this).withPosition(10, 4).withRed())
        addStone(Stone2(this).withPosition(12, 4).withRed())

        addStone(Stone2(this).withPosition(1, 5).withBlue())
        addStone(Stone2(this).withPosition(3, 5).withGreen())
        addStone(Stone2(this).withPosition(5, 5).withRed())
        addStone(Stone2(this).withPosition(7, 5).withRed())
        addStone(Stone2(this).withPosition(9, 5).withRed())
        addStone(Stone2(this).withPosition(11, 5).withRed())
        addStone(Stone2(this).withPosition(13, 5).withRed())

        addStone(Stone2(this).withPosition(2, 2).withBlue())
        addStone(Stone2(this).withPosition(4, 2).withGreen())
        addStone(Stone2(this).withPosition(6, 2).withRed())
        addStone(Stone2(this).withPosition(8, 2).withRed())
        addStone(Stone2(this).withPosition(10, 2).withRed())
        addStone(Stone2(this).withPosition(12, 2).withRed())


         */
    }


}