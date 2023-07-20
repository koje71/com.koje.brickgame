package com.koje.brickgame.core

import com.koje.brickgame.core.boards.Board
import com.koje.brickgame.core.stones.Stone
import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Position
import kotlin.math.sin

class Marble(board: Board) : ImageComponent(Playground) {

    val vector = Position()
    val position = board.marbleSource.position.copy()
    val positionOld = Position()
    var size = 0f
    var speed = 0.002f
    var flying = true
    var height = 0f
    var type = nextType

    var buildSpeed = 0.2f

    private var state: () -> Unit = {
        if (size < 0.07f) {
            size += Playground.loopTime * 0.00005f * buildSpeed
        } else {
            state = starting
        }
    }

    private val starting = {
        if (board.marbleSource.creation == this) {
            board.marbleSource.creation = null
        }

        vector.x = board.target.position.x - position.x
        vector.y = board.target.position.y - position.y
        state = moving
    }

    var stoneCheck=0

    private var moving = {
        positionOld.copyFrom(position)

        movingX()
        movingY()

        // kollision links
        if (position.x < -0.48f) {
            vector.x *= -1
            movingX()
        }

        // kollision rechts
        if (position.x > 0.48f) {
            vector.x *= -1
            movingX()
        }

        // kollision mit blocker
        if (positionOld.y > 0.48f && position.y <= 0.48f && board.blocker.blocked(position.x)) {
            vector.y *= -1
            movingY()

            vector.x -= 0.5f * (board.blocker.position.x - position.x)
            movingX()
        }

        // ausgang nach unten
        if (position.y < -0.2f) {
            death = true
        }

        // kollision oben
        if (position.y > Playground.ratio) {
            vector.y *= -1
            movingY()
        }

        // flughöhe berechnen
        if (flying) {
            height = 0.05f * sin((position.y - board.marbleSource.position.y) * 360f / 0.75f)
            if (height < 0f) {
                flying = false
                height = 0f
            }
        }


        stoneCheck++
        if(stoneCheck>0) {
            Playground.currentBoard.stones.components.forEach {
                if (it is Stone) {
                    it.checkCollision(this)
                }
            }
            stoneCheck = 0
        }
    }


    fun movingX() {
        position.x += vector.x * Playground.loopTime * speed
    }

    fun movingY() {
        position.y += vector.y * Playground.loopTime * speed
    }


    init {
        nextType = when (nextType) {
            Names.Red -> Names.Green
            Names.Green -> Names.Blue
            else -> Names.Red
        }

        board.addComponent(this)

        image = Playground.picmap
        index = when (type) {
            Names.Red -> 3
            Names.Green -> 4
            else -> 5
        }
        count = 100
        plane = 3

        addProcedure {
            move(position)
            scale(
                when (flying) {
                    true -> size + height
                    else -> size
                }
            )
            state.invoke()
        }
    }

    fun passedX(value: Float): Boolean {
        if (positionOld.x < value && position.x >= value) return true
        if (positionOld.x > value && position.x <= value) return true
        return false
    }

    fun passedY(value: Float): Boolean {
        if (positionOld.y < value && position.y >= value) return true
        if (positionOld.y > value && position.y <= value) return true
        return false
    }

    fun sin(value: Float): Float {
        return sin(Math.toRadians(value.toDouble())).toFloat()
    }

    companion object {
        var nextType = Names.Red
    }
}