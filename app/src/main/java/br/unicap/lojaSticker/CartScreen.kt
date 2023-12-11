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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun CartScreen (navController: NavController) {

    Surface {

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            horizontalAlignment = AbsoluteAlignment.Left,
            verticalArrangement = Arrangement.Center
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    buildAnnotatedString { withStyle(style = SpanStyle(color = Color.Green, fontFamily = FontFamily.Default)) {
                        append("DOZ. AJ")
                    } }
                )

                Spacer(modifier = Modifier.padding(horizontal = 120.dp))

                Button(
                    onClick = { navController.popBackStack()},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier.padding(15.dp)
                ) {
                    Icon(Icons.Default.Home, contentDescription = "Voltar")
                }
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red),
                horizontalArrangement = Arrangement.Center,
                ) {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Gray,
                                fontFamily = FontFamily.Default,
                                fontSize = 30.sp
                            )
                        ) {
                            append("Compra")
                        }
                    },
                    Modifier.padding(30.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .shadow(elevation = 30.dp)
            )
            {//finalizar depois
                /*
                LazyColumn {
                    items(ShoppingCart.getStickers()) { cartItem ->
                        CartListView(cartItem,
                            onIncreaseClick = { }
                        ) {  }
                    }
                }*/
            }

            Row ( modifier = Modifier
                .padding(20.dp)
                .background(Color.White)
                .clip(shape = CircleShape),
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = "Total: " + sumPrices(ShoppingCart.getStickers()), fontSize = 20.sp)
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
            )

        }
    }

}

fun sumPrices(sticker: List<CartItem>): Double {
    var totalPrice = 0.0
    for (cartItem in ShoppingCart.getStickers()) {
        totalPrice += cartItem.sticker.price * cartItem.qtd
    }
    return totalPrice
}


@Preview
@Composable
fun CartScreenPreview () {
    CartScreen(navController = rememberNavController())
}
