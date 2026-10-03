package com.example.quiz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnswerOptionsFragment : Fragment(R.layout.fragment_answer_options) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionIndex = arguments?.getInt(ARG_QUESTION_INDEX, 1) ?: 1

        val tvQuestionTitle = view.findViewById<TextView>(R.id.tvQuestionTitle)
        val tvFeedback = view.findViewById<TextView>(R.id.tvFeedback)

        val titleResId: Int
        val correctButtonId: Int
        val detailResId: Int

        when (questionIndex) {
            1 -> {
                titleResId = R.string.q_largest_planet
                correctButtonId = R.id.btnJupiter
                detailResId = R.string.detail_jupiter
            }
            2 -> {
                titleResId = R.string.q_most_moons
                correctButtonId = R.id.btnSaturn
                detailResId = R.string.detail_saturn
            }
            3 -> {
                titleResId = R.string.q_spins_on_side
                correctButtonId = R.id.btnUranus
                detailResId = R.string.detail_uranus
            }
            else -> {
                titleResId = R.string.q_largest_planet
                correctButtonId = R.id.btnJupiter
                detailResId = R.string.detail_jupiter
            }
        }

        tvQuestionTitle.setText(titleResId)

        val planetButtons: List<Int> = listOf(
            R.id.btnMercury,
            R.id.btnVenus,
            R.id.btnEarth,
            R.id.btnMars,
            R.id.btnJupiter,
            R.id.btnSaturn,
            R.id.btnUranus,
            R.id.btnNeptune,
        )

        for (btnId in planetButtons) {
            view.findViewById<Button>(btnId)?.setOnClickListener {
                tvFeedback.visibility = View.VISIBLE
                if (btnId == correctButtonId) {
                    val feedbackText = getString(R.string.result_correct) + getString(detailResId)
                    tvFeedback.text = feedbackText
                } else {
                    tvFeedback.text = getString(R.string.result_incorrect)
                }
            }
        }
    }

    companion object {
        private const val ARG_QUESTION_INDEX = "question_index"

        fun newInstance(questionIndex: Int): AnswerOptionsFragment {
            val fragment = AnswerOptionsFragment()
            val args = Bundle()
            args.putInt(ARG_QUESTION_INDEX, questionIndex)
            fragment.arguments = args
            return fragment
        }
    }
}
