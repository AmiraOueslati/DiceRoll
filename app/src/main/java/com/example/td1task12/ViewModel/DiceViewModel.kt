package com.example.td1task12.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.td1task12.R

class DiceViewModel : ViewModel() {
    var diceRoll by mutableStateOf(1) // Initialisez à 1 pour éviter d'avoir une image vide
    var player1Score by mutableStateOf(0)
    var player2Score by mutableStateOf(0)

    fun rollDice() {
        diceRoll = (1..6).random() // Simule un lancer de dé
        player1Score += diceRoll

    }

    fun resetGame() {
        diceRoll = 1 // Réinitialiser à 1 pour correspondre à l'image par défaut
        player1Score = 0
        player2Score = 0
    }

    fun getDiceImage(): Int {
        return when (diceRoll) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4png
            5 -> R.drawable.dice5
            6 -> R.drawable.dice6
            else -> R.drawable.dice1 // Valeur par défaut
        }
    }
}
