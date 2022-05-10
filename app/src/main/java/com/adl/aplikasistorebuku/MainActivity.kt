package com.adl.aplikasistorebuku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.adl.aplikasistorebuku.ui.theme.AplikasiStoreBukuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiStoreBukuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BookOutlet()
                }
            }
        }
    }
}

@Composable
fun BookOutlet(){
    Column {
        Text(text = "Outlet Buku")

        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            shape = RoundedCornerShape(16.dp), elevation = 5.dp) {
            BookItem()
        }

    }
}

@Composable
fun BookItem(){
    var showBookSinopsis by remember { mutableStateOf(false)}

    Column(modifier = Modifier.clickable {
        showBookSinopsis = showBookSinopsis.not()
    }) {
        Row(modifier = Modifier.padding(12.dp)) {


            AsyncImage(
                model = "https://assets.promediateknologi.com/crop/0x0:0x0/x/photo/2022/01/11/3756627481.jpeg",
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                contentScale = ContentScale.Fit)

            Column(modifier = Modifier.padding(5.dp,0.dp,0.dp,0.dp)) {
                Text(text = "KKN Desa Metaverse", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp))
                Text(text = "Rp 100.000", style = TextStyle(fontWeight = FontWeight.Light, fontSize = 12.sp))
            }
        }

        AnimatedVisibility(visible = showBookSinopsis) {
            Text(text = "Pemuda nyasar ke metaverse", style = TextStyle(fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic, fontSize = 11.sp),
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 16.dp))
        }
    }
}