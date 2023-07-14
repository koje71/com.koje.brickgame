package com.koje.brickgame.core

import com.koje.brickgame.core.stones.Stone
import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Position
import kotlin.math.sin

class Marble : ImageComponent(Playground) {

    val vector = Position()
    val position = Playground.marbleSource.position.copy()
    val positionOld = Position()
    var size = 0f
    var speed = 0.002f
    var flying = true
    var height = 0f

    var buildSpeed = 2.2f

    private var state: () -> Unit = {
        if (size < 0.07f) {
            size += Playground.loopTime * 0.00005f * buildSpeed
        } else {
            state = starting
        }
    }

    private val starting = {
        if (Playground.marbleSource.creation == this) {
            Playground.marbleSource.creation = null
        }

        vector.x = Playground.target.position.x - position.x
        vector.y = Playground.target.position.y - position.y
        state = moving
    }

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
        if (positionOld.y > 0.48f && position.y <= 0.48f && Playground.blocker.blocked(position.x)) {
            vector.y *= -1
            movingY()
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
            height = 0.05f * sin((position.y - Playground.marbleSource.position.y) * 360f / 0.75f)
            if (height < 0f) {
                flying = false
                height = 0f
            }
        }


        Playground.currentBoard.stones.forEach {
            it.checkCollision(this)
        }
    }


    fun movingX() {
        position.x += vector.x * Playground.loopTime * speed
    }

    fun movingY() {
        position.y += vector.y * Playground.loopTime * speed
    }

    init {
        Playground.currentBoard.addComponent(this)

        image = Playground.picmap
        index = 3
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

    fun passedX(value:Float):Boolean{
        if(positionOld.x<value && position.x>=value) return true
        if(positionOld.x>value && position.x<=value) return true
        return false
    }

    fun passedY(value:Float):Boolean{
        if(positionOld.y<value && position.y>=value) return true
        if(positionOld.y>value && position.y<=value) return true
        return false
    }

    fun sin(value: Float): Float {
        return sin(Math.toRadians(value.toDouble())).toFloat()
    }
}