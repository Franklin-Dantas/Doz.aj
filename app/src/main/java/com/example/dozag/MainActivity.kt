package com.example.dozag.list_item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.dozag.R
import com.example.dozag.model.Sticker
import androidx.compose.foundation.Image as Image1

@Composable
fun StickerItem(

){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(0.dp, 10.dp, 0.dp, 10.dp)
    ) {

        val (
            imgSticker,
            txtStickerName,
            txtStickerDescription,
            txtPrice,
            btAddCart,
            conteinerImg,
            rowItem
        ) = createRefs()
        Card(
            modifier = Modifier
                .constrainAs(conteinerImg) {
                    top.linkTo(parent.top, 0.dp)
                    start.linkTo(parent.start, 0.dp)

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
        ) {

        }

        Image1(
            painter = painterResource(id = R.drawable.sticker1),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(imgSticker) {
                    top.linkTo(conteinerImg.top, 0.dp)
                    start.linkTo(conteinerImg.start, 0.dp)
                    end.linkTo(conteinerImg.end, 0.dp)
                    bottom.linkTo(conteinerImg.bottom, 0.dp)
                }
                .size(60.dp)
        )

        //titulo da imagem
        Text(
            text = "Stiker Pato",
            fontSize = 18.sp,
            fontStyle = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier.constrainAs(txtStickerName){
                top.linkTo(parent.top,30.dp)
                start.linkTo(conteinerImg.end,0.dp)
            }
        )

        //descrição da imagem
        Text(
            text = "Essa figurinha pertence ao primeiro pack",
            fontSize = 14.sp,
            fontStyle = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.constrainAs(txtStickerDescription){
                top.linkTo(txtStickerName.bottom)
                start.linkTo(conteinerImg.end,0.dp)
                end.linkTo(parent.end)
            }.padding(65.dp,10.dp,40.dp,0.dp),
            maxLines = 2
        )

        //Valor do sticker
        Text (
            text = "5 R$",
            fontSize = 18.sp,
            fontStyle = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.constrainAs(txtPrice){
                top.linkTo(txtStickerDescription.bottom,20.dp)
                start.linkTo(conteinerImg.end,0.dp)
            }
        )

    }
}


@Composable
@Preview
private fun StickerItemPreview(){
    StickerItem()
}
