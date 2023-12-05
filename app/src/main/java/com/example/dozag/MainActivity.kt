package com.example.dozag.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.dozag.R
import com.example.dozag.model.Sticker

@Composable
fun StickerItem(

){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(0.dp, 10.dp, 0.dp, 10.dp)
    ) {

        val(
            imgSticker,
            txtStickerName,
            txtStickerDescription,
            txtPrice,
            btAddCart,
            conteinerImg,
            rowItem
        ) = createRefs()
        Card (
            modifier = Modifier
                .constrainAs(conteinerImg) {
                    top.linkTo(parent.top,0.dp)
                    start.linkTo(parent.start,0.dp)

                }
                .size(130.dp)
                .padding(20.dp),
            //passar cor de fundo
            colors = CardDefaults.cardColors(
            ),
            shape = ShapeDefaults.Medium,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ){

        }

        Image(
            painter = painterResource(id = R.drawable.sticker1) ,
            contentDescription = null,
            modifier = Modifier
                //finalizar
                .constrainAs(imgSticker) {
                    
                }
                .size(60.dp)
        )
    }
}
@Composable
@Preview
private fun StickerItemPreview(){
    StickerItem()
}
