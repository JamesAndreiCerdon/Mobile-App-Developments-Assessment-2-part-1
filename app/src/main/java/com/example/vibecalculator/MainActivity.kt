package com.example.vibecalculator

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var inputSituation: EditText
    private lateinit var calcButton: Button
    private lateinit var outputResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Ensures the layout uses edge-to-edge design
        setContentView(R.layout.activity_main)

        // Handling window insets for edge-to-edge layout (full-screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Connect UI elements
        inputSituation = findViewById(R.id.inputSituation)
        calcButton = findViewById(R.id.calcButton)
        outputResult = findViewById(R.id.outputResult)

        calcButton.setOnClickListener {
            val situation = inputSituation.text.toString()
            val vibeScore = calculateVibeScore(situation)
            val vibeLevel = interpretScore(vibeScore)
            outputResult.text = "Vibe Score: $vibeScore/100\nMood: $vibeLevel"
        }

        // Show modal pop-up when the app is launched
        showModal()
    }

    // Show a modal pop-up
    private fun showModal() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Welcome to Vibe Calculator")
            .setMessage("This app helps you calculate your vibe score based on your input. Let's get started!")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    // Calculate the "vibe score" based on the input situation
    private fun calculateVibeScore(situation: String): Int {
        var score = 50

        // Logic based on keywords found in the situation
        if (situation.contains("awkward", true)) score += 10
        if (situation.contains("ex", true)) score -= 15
        if (situation.contains("party", true)) score += 5
        if (situation.contains("ghost", true)) score -= 20
        if (situation.contains("flirty", true)) score += 10

        // Adding a bit of randomness to the score
        score += Random.nextInt(-10, 10)
        return score.coerceIn(0, 100)
    }

    // Interpret the score and return a mood based on it
    private fun interpretScore(score: Int): String {
        return when (score) {
            in 0..20 -> "🧊 Ice Cold Vibes"
            in 21..40 -> "😬 Awkward Energy"
            in 41..60 -> "🌀 Mildly Chaotic"
            in 61..80 -> "🔥 Spicy Situation"
            else -> "💀 High Drama Alert"
        }
    }
}
