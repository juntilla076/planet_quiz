package com.example.quiz

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class QuestionsFragment : Fragment(R.layout.fragment_questions) {

    interface OnQuestionSelectedListener {
        fun onQuestionSelected(questionIndex: Int)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listener = activity as? OnQuestionSelectedListener

        view.findViewById<Button>(R.id.btnQuestion1).setOnClickListener {
            listener?.onQuestionSelected(1)
        }
        view.findViewById<Button>(R.id.btnQuestion2).setOnClickListener {
            listener?.onQuestionSelected(2)
        }
        view.findViewById<Button>(R.id.btnQuestion3).setOnClickListener {
            listener?.onQuestionSelected(3)
        }
    }
}