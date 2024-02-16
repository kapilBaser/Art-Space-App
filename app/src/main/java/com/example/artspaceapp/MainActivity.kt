package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}


data class Items(val id: Int, val desc: Int, val owenedBy: Int)

val items = listOf<Items>(
    Items(R.drawable.art1,
         R.string.art1_desc,
        R.string.owner),
    Items(R.drawable.art2,
        R.string.art2_desc,
        R.string.owner),
    Items(R.drawable.art3,
        R.string.art3_desc,
        R.string.owner),

)

@Composable
fun ArtSpaceLayout(){
    var index by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween) {
        Card(elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.7f)

                .shadow(elevation = 12.dp,
                    shape = RoundedCornerShape(8.dp)
                )
                .background(Color.White, RoundedCornerShape(8.dp))
            .padding(36.dp),) {
            Image(painter = painterResource(items.get(index).id) , contentDescription = null,
                contentScale = ContentScale.Crop,
                )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color(191, 231, 245, 255))
            .padding(16.dp)) {
            Text(text = stringResource(id = items.get(index).desc),
                fontSize = 16.sp,
                color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = stringResource(id = items.get(index).owenedBy),
                color = Color.Black)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {
                if(index==0){
                    index = 2
                }else{
                    index -= 1
                }
            }) {
                Text(text = stringResource(id = R.string.previous))
            }
            Button(onClick = { index = (index+1) % 3 }) {
                Text(text = stringResource(id = R.string.next))
            }
        }
    }
}




