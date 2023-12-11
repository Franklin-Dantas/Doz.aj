package br.unicap.lojasticker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LojaScreen(navController: NavController){
    //criando lista de stickers
    val sticker = listOf(
        Sticker
            (
            image = R.drawable.sticker1,
            name = "Sticker 1",
            price = 5.0
        ),
        Sticker(
            image = R.drawable.sticker2,
            name = "Sticker 2",
            price = 10.0
        ),
        Sticker(
            image = R.drawable.sticker3,
            name = "Sticker 3",
            price = 11.0
        ),
        Sticker(
            image = R.drawable.sticker4,
            name = "Sticker 4",
            price = 12.0
        ),
        Sticker(
            image = R.drawable.sticker5,
            name = "Sticker 5",
            price = 7.0
        ),
        Sticker(
            image = R.drawable.sticker6,
            name = "Sticker 6",
            price = 3.0
        ),
        Sticker(
            image = R.drawable.sticker7,
            name = "Sticker 7",
            price = 8.0
        ),
        Sticker(
            image = R.drawable.sticker8,
            name = "Sticker 8",
            price = 4.0
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                buildAnnotatedString { withStyle(style = SpanStyle(color = Color.Green, fontFamily = FontFamily.Default)) {
                    append("DOZ. AJ")
                } }
            )
            
            Spacer(modifier = Modifier.padding(horizontal = 120.dp))
            
            Button(
                onClick = {navController.navigate("cartScreen")},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                modifier = Modifier.padding(15.dp)
            ) {
                Icon(Icons.Default.ShoppingCart , contentDescription = "Cart")
            }
            
        }
        Box(modifier = Modifier.fillMaxSize()){
            LazyVerticalGrid(
                modifier = Modifier.padding(15.dp),
                columns = GridCells.FixedSize(200.dp),
                verticalArrangement =  Arrangement.spacedBy(15.dp),
                horizontalArrangement = Arrangement.Center,
            ){
                item (sticker){
                    StickerViewPreview()
                }
            }
        }
    }
}

@Composable
fun AppNavgation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "LojaScreen" ){
        composable("LojaScreen"){
            LojaScreen(navController)
        }
        composable("CartScreen"){
            CartScreen(navController)
        }
    }
}

@Preview
@Composable
fun LojaScreenPreview (){
    LojaScreen(navController = rememberNavController())
}