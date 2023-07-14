package com.koje.brickgame.view

import com.koje.brickgame.core.Playground
import com.koje.framework.view.BaseActivity
import com.koje.framework.view.FrameLayoutBuilder

class Activity : BaseActivity() {

    override fun createLayout(target: FrameLayoutBuilder) {
        with(target) {
            addLinearLayout {
                setOrientationVertical()
                setSizeMatchParent()

                addSurfaceView {
                    setSurface(Playground)
                }
            }
        }
    }
}

