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
            0 -> "🧊 Absolute Zero Vibes"
            1 -> "😶 Vibe... barely detectable"
            2 -> "🥶 Antarctic Energy"
            3 -> "🫥 Faded Into The Background"
            4 -> "😴 Snoozefest Central"
            5 -> "🙄 Nope Vibes"
            6 -> "😐 Emotionally Flat"
            7 -> "🫤 Mildly Uncomfortable"
            8 -> "😶‍🌫️ Lost in the Vibe Fog"
            9 -> "😓 Try Again Later"
            10 -> "😬 Painfully Awkward"
            11 -> "🫣 Secondhand Embarrassment"
            12 -> "😟 Feels Weird"
            13 -> "🤔 Misinterpreted Energy"
            14 -> "😕 Disconnected Vibes"
            15 -> "🥱 Low Battery Mode"
            16 -> "😒 Mildly Annoyed"
            17 -> "😑 Emotionally Unavailable"
            18 -> "🧟 Social Zombie"
            19 -> "😩 Vibe Needs Therapy"
            20 -> "😖 Full-On Awkward"
            21 -> "😬 Vibe’s a Bit Off"
            22 -> "🫠 Social Meltdown Imminent"
            23 -> "🤡 Clown Energy (Accidental)"
            24 -> "🫢 Slight Oops Moment"
            25 -> "😐 Weird Silence"
            26 -> "🧃 Dry as Day-Old Toast"
            27 -> "🛑 Minor Red Flag"
            28 -> "😗 Social Buffering"
            29 -> "🤷‍♂️ Mid-Level Confusion"
            30 -> "🧊 Kinda Frozen"
            31 -> "😿 Cringe Echoes"
            32 -> "🥲 Barely Holding On"
            33 -> "😔 Mid-Mid Energy"
            34 -> "🫥 Background Extra Mood"
            35 -> "🫤 Lukewarm Soup Energy"
            36 -> "😶‍🌫️ Muted Vibe Output"
            37 -> "🤐 Closed Off Vibes"
            38 -> "😅 Nervous Laughter Only"
            39 -> "🙃 Mild Social Spiral"
            40 -> "🌀 Confused But Here"
            41 -> "😬 Slightly Chaotic Neutral"
            42 -> "🫨 Unstable but Fun"
            43 -> "🥴 Spinning Socially"
            44 -> "😵‍💫 Small Talk Spiral"
            45 -> "🤕 Mild Vibe Injury"
            46 -> "😆 Accidental Humor"
            47 -> "🫠 Controlled Chaos"
            48 -> "😎 Lowkey Cool"
            49 -> "🙂 Calm Before the Vibe"
            50 -> "😌 Chill Threshold"
            51 -> "😇 Soft Social Glow"
            52 -> "🤠 Casual Cowboy Mood"
            53 -> "😏 A Little Suspicious"
            54 -> "😛 Vibes Trying to Flirt"
            55 -> "😜 Goofy Mood Engaged"
            56 -> "🫶 Cute Vibe Detected"
            57 -> "😇 Unproblematic Energy"
            58 -> "🫧 Gentle Breeze Energy"
            59 -> "🕺 Just Started Vibing"
            60 -> "🎉 Something’s Brewing"
            61 -> "😈 Slightly Spicy Now"
            62 -> "👻 Flirty Ghost Vibes"
            63 -> "👀 Eye Contact Activated"
            64 -> "😝 Party Starter Pack"
            65 -> "💃 Social Butterfly Mode"
            66 -> "🧃 Juice is Flowing"
            67 -> "🎭 Playful Energy Rising"
            68 -> "🍷 Smooth & Social"
            69 -> "😏 Peak Rizz Detected"
            70 -> "🔥 Warm Vibes Only"
            71 -> "🎬 Scene-Stealing Vibes"
            72 -> "🌈 Radiant Chaos"
            73 -> "🧨 Firecracker Social Spark"
            74 -> "🦄 Unique & Vibin'"
            75 -> "👑 Confident Main Character"
            76 -> "💥 Drama But In A Fun Way"
            77 -> "💃 Grooving Through Life"
            78 -> "🧜 Siren Song Activated"
            79 -> "🕷️ Magnetic Mystery"
            80 -> "🔥 Pure Heat"
            81 -> "🌪️ Full-On Storm Vibe"
            82 -> "🎆 Sparkling Personality"
            83 -> "🚨 Social Alarm Triggered"
            84 -> "🦁 Loud and Proud"
            85 -> "💅 Effortlessly Fierce"
            86 -> "🎤 Microphone Confidence"
            87 -> "🌟 Star of the Room"
            88 -> "💫 Cosmic Flare"
            89 -> "👽 Vibes from Another Planet"
            90 -> "🧙 Magic in the Air"
            91 -> "🛸 Vibe Out of This World"
            92 -> "👑 Crown-Worthy Energy"
            93 -> "🧛 Smooth, Mysterious, Bold"
            94 -> "🌋 Social Eruption"
            95 -> "💣 Drama Bomb Activated"
            96 -> "🦅 Sky High Confidence"
            97 -> "🌠 Dream Vibes Realized"
            98 -> "🔥🔥 Legendary Mood"
            99 -> "💀 Dangerously Iconic"
            100 -> "👑 Vibe Overlord Mode"
            else -> "🌀 Undefined Energy"
        }
    }
}
