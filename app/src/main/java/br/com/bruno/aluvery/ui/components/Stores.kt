package br.com.bruno.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.bruno.aluvery.R
import br.com.bruno.aluvery.model.Store
import coil.compose.AsyncImage

@Composable
fun StoreItem(
    store: Store,
    modifier: Modifier = Modifier
) {
    Surface(modifier) {
        Column(
            modifier = Modifier
                .heightIn(min = 150.dp, max = 200.dp)
                .width(100.dp)
                .background(Color.White)
        ) {
            val imageSize = 100.dp
            AsyncImage(
                model = store.logo,
                contentDescription = "Logo da Loja",
                modifier = Modifier
                    .size(imageSize)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder)
            )
            Text(
                modifier = Modifier.padding(8.dp),
                text = store.name,
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                maxLines = 2,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StoreItemPreview() {
    StoreItem(
        Store(
            name = LoremIpsum(50).values.first(),
        )
    )
}