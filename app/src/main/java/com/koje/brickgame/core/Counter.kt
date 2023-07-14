package com.koje.brickgame.core

import com.koje.framework.App
import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.ImageComponent

class Counter(val posX: Float, val posY: Float, val scale: Float) : ComponentGroup(Playground) {

    class Digit : ImageComponent(Playground) {
        var xPos = 0f
    }

    var digits = mutableListOf<Digit>()

    fun setValue(intValue: Int) {
        var value = "$intValue     "
        var offset = 0f
        for (i in 0..4) {
            setImage(digits[i], value[i])
            offset += setOffset(digits[i], value[i], offset)
        }
    }

    fun setColor(id:Int){
        for (i in 0..4) {
            digits[i].color = App.instance.getColor(id)
        }
    }

    fun setImage(digit: Digit, value: Char) {
        digit.index = when (value) {
            '0' -> 80
            '1' -> 81
            '2' -> 82
            '3' -> 83
            '4' -> 84
            '5' -> 85
            '6' -> 86
            '7' -> 87
            '8' -> 88
            '9' -> 89
            else -> 12
        }
    }

    fun setOffset(digit: Digit, value: Char, offset: Float): Float {
        digit.xPos = offset
        return when (value) {
            '1' -> 0.6f
            '2', '3', '5' -> 0.7f
            else -> 0.8f
        }
    }

    init {
        plane = 3
        Playground.addComponent(this)

        for (i in 0..4) {
            addDigit()
        }

        addProcedure {
            move(posX, posY)
            scale(scale)
        }
    }

    fun addDigit() {
        with(Digit()) {
            image = Playground.picmap
            count = 400

            addProcedure {
                move(xPos, 0f)
            }

            addComponent(this)
            digits.add(this)
        }
    }
}