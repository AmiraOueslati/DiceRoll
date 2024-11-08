package com.example.td1task12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.td1task12.ViewModel.DiceViewModel
import com.example.td1task12.ui.theme.TD1Task12Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TD1Task12Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceApp()
                }
            }
        }
    }
}

@Composable
fun DiceApp(diceViewModel: DiceViewModel = viewModel()) {
    val diceRoll = diceViewModel.diceRoll
    val player1Score = diceViewModel.player1Score
    val diceImage = diceViewModel.getDiceImage()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Afficher l'image du dé
        Image(
            painter = painterResource(id = diceImage),
            contentDescription = "Dice Roll",
            modifier = Modifier.size(100.dp) // Ajustez la taille selon vos besoins
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Player 1 Score: $player1Score")
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { diceViewModel.rollDice() }) {
            Text("Roll Dice")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { diceViewModel.resetGame() }) {
            Text("Reset Game")
        }
    }
}
