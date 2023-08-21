package com.example.mobilepromo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.mobilepromo.PromoViewModel
import com.example.mobilepromo.model.PromoModelItem

@Composable
fun DetailScreen(model: PromoViewModel, id:Int) {
    model.getDetailPromo(id = id)
    val data: PromoModelItem = model.promo!!

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painter = rememberImagePainter(data = data.img?.formats?.medium?.url) ,contentDescription = null)
        }

        Divider(color = androidx.compose.ui.graphics.Color.LightGray, thickness = 2.dp,modifier = Modifier.padding(vertical = 20.dp))
        TextRow(jenisnya = "Nama Promo", isinya = "${data.nama}")
        TextRow(jenisnya = "Lokasi", isinya = "${data.lokasi}")
        Divider(color = androidx.compose.ui.graphics.Color.LightGray, thickness = 1.dp,modifier = Modifier.padding(vertical = 20.dp))
        Text(text = "Deskripsi",
            style = TextStyle(
                fontSize = 30.sp
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = data.desc!!)
        Divider(color = androidx.compose.ui.graphics.Color.LightGray, thickness = 1.dp,modifier = Modifier.padding(vertical = 20.dp))


    }

}


@Composable
fun TextRow(jenisnya: String, isinya:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .weight(1.0f)) {
            Text(text = jenisnya)
        }
        Row(modifier = Modifier
            .weight(2.0f)) {
            Text(text = isinya)
        }
    }
}
