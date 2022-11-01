package com.example.velog.motion

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.constraintlayout.widget.ConstraintSet
import com.example.velog.R
import com.example.velog.Tinder.MainActivity
import com.example.velog.databinding.FragmentPlayerBinding
import kotlinx.android.synthetic.main.activity_async.*
import kotlin.math.abs

class PlayerFragment :BaseFragment<FragmentPlayerBinding>(FragmentPlayerBinding::inflate){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            motionLayout.setTransitionListener(object : MotionLayout.TransitionListener{
                override fun onTransitionStarted(motionLayout: MotionLayout?,
                    startId: Int, endId: Int) {}

                override fun onTransitionChange(motionLayout: MotionLayout?,
                    startId: Int, endId: Int, progress: Float
                ) {
                    if (endId==R.id.end){
                        (activity as ActivityMotion).also { mainActivity ->
                            mainActivity.findViewById<MotionLayout>(R.id.baseMotionLayout)
                                .progress = abs(progress)
                        }
                    }
                }
                override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {}
                override fun onTransitionTrigger(motionLayout: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) {
                    if(triggerId==binding.videoContainerView.id){

                    }
                }

            })
        }
    }

}