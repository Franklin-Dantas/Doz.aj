package com.example.dozag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.dozag.ui.theme.DozagTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DozagTheme {
                LojaSticker()
            }
        }
    }

    @Composable
    private fun LojaSticker(){
        Text(text = "Loja de Stickers")
        Column (modifier = Modifier.fillMaxSize().background(color = Color.Black)){

        }
    }

    @Preview
    @Composable
    fun PrimeiraTelaPreview() {
        LojaSticker()
    }
}
