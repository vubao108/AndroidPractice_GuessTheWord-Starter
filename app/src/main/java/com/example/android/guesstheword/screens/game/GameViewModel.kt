package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.core.view.ViewCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel: ViewModel() {
    private val _word = MutableLiveData<String>()
    val word:LiveData<String>
        get() = _word
    // The current score
    private val _score = MutableLiveData<Int>()
    val score:LiveData<Int>
        get() = _score
    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }
    init{
        //Log.i("GameViewModal","GameViewModel created")
        _word.value = ""
        _score.value = 0
        resetList()
        nextWord()

        Timber.i("GameViewModel created")
    }
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            _word.value = wordList.removeAt(0)
        }

    }
    /** Methods for buttons presses **/
    fun onSkip() {
        _score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (score.value)?.plus(1)
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed")
    }

}