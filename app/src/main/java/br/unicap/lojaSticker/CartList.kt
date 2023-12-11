package br.unicap.lojasticker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun CartListView(cartItem: Int, onIncreaseClick: (CartItem) -> Unit, onDecreaseClick: (CartItem)->Unit){
    val cartLocalItem  = cartItem.sticker
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Column(modifier = Modifier.padding(bottom = 15.dp)) {
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(text = cartLocalItem.StickerName, fontWeight = FontWeight.Bold)
                Text(text = "${cartLocalItem.price}")
            }
            Text(text = "Acervo: " + cartLocalItem.qtd, fontSize = 15.sp)
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ){
                    Text(text = cartLocalItem.name)
                }
                Button(
                    onClick = {
                        ShoppingCart.removeItemFromCart(cartLocalItem)
                              },
                    modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = "Remover Sticker")
                }
            }
        }
    }
}
