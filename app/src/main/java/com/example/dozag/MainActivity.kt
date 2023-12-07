package com.example.dozag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.dozag.model.Sticker
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
        val stickerList : MutableList<Sticker> = mutableListOf(
            Sticker
                (
                imgSticker = R.drawable.sticker1,
                txtStickerName = "Sticker 1",
                txtStickerDescription = "Essa figurinha pertence ao primeiro pack",
                txtPrice = "5 R$",
            ),
            Sticker(
                imgSticker = R.drawable.sticker2,
                txtStickerName = "Sticker 2",
                txtStickerDescription = "Essa figurinha pertence ao primeiro pack",
                txtPrice = "5 R$",
            ),
            Sticker(
                imgSticker = R.drawable.sticker3,
                txtStickerName = "Sticker 3",
                txtStickerDescription = "Essa figurinha pertence ao primeiro pack",
                txtPrice = "5 R$",
            ),
            Sticker(
                imgSticker = R.drawable.sticker4,
                txtStickerName = "Sticker 4",
                txtStickerDescription = "Essa figurinha pertence ao primeiro pack",
                txtPrice = "5 R$",
            ),
            Sticker(
                imgSticker = R.drawable.sticker5,
                txtStickerName = "Sticker 5",
                txtStickerDescription = "Essa figurinha pertence ao primeiro pack",
                txtPrice = "5 R$",
            ),
            Sticker(
                imgSticker = R.drawable.sticker6,
                txtStickerName = "Sticker 6",
                txtStickerDescription = "Essa figurinha pertence ao primeiro pack",
                txtPrice = "5 R$",
            ),
            Sticker(
                imgSticker = R.drawable.sticker7,
                txtStickerName = "Sticker 7",
                txtStickerDescription = "Essa figurinha pertence ao primeiro pack",
                txtPrice = "5 R$",
            ),
            Sticker(
                imgSticker = R.drawable.sticker8,
                txtStickerName = "Sticker 8",
                txtStickerDescription = "Essa figurinha pertence ao primeiro pack",
                txtPrice = "5 R$",
            )

        )
        Text(text = "Loja de Stickers")
        Column (modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
        ){
            LazyColumn(){

            }
        }
    }

    @Preview
    @Composable
    fun PrimeiraTelaPreview() {
        LojaSticker()
    }
}
