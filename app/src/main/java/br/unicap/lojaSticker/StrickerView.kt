package br.unicap.lojasticker

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StickerView(sticker: Sticker) {

    val qtd = remember { mutableStateOf(1) }
    val price = sticker.price

    Column(modifier = Modifier.padding(5.dp)) {
        Image(
            painter = painterResource(sticker.image),
            contentDescription = null)
        Column(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Text(sticker.name,
                Modifier.align(Alignment.CenterHorizontally))
            Text(price.toString(),Modifier.align(Alignment.CenterHorizontally))
            ElevatedButton(onClick = {
                val id = 1
                onAddToCart(sticker)
            },
                Modifier.align(Alignment.CenterHorizontally)
            )
            {
                Text("Comprar")
            }
            Row(modifier = Modifier.padding(vertical = 10.dp, )) {
                ElevatedButton(onClick = {
                    qtd.value++
                }) {
                    Text("Add")
                }
                Text(qtd.value.toString(),
                    modifier = Modifier.padding(10.dp),
                    fontSize = 25.sp
                )
                ElevatedButton(onClick = {
                    qtd.value--
                }) {
                    Text("Rmv")
                }
            }
        }
    }
}

fun onAddToCart(sticker: Sticker) {
    ShoppingCart.addItemToCart(CartItem(sticker, sticker.qtd))
}

data class CartItems(
    val sticker: Sticker,
    val qtd: Int
)

object ShoppingCart {

    private val cartItems: MutableState<MutableList<CartItem>> = mutableStateOf(mutableListOf())

    fun addItemToCart(item: CartItem) {
        cartItems.value.addAll(listOf(item))
    }

    fun removeItemFromCart(item: CartItem) {
        cartItems.value.removeAll(listOf(item))
    }

    fun getStickers(): List<CartItem> {
        return cartItems.value.toList()
    }

}
@Preview
@Composable
fun StickerViewPreview () {
    StickerView(
        sticker = Sticker
            (
        name = "Sticker1",
        image =  R.drawable.sticker1,
        price = 5.0)
    )
}