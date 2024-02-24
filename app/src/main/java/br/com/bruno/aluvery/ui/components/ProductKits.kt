package br.com.bruno.aluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.bruno.aluvery.R

@Composable
fun ProductKits(
    idImage: Int,
    modifier: Modifier = Modifier,
    text: String
) {
    Surface(
        modifier,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 4.dp
    ) {
        val sizeMax = 300.dp
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp, max = sizeMax)
                .background(Color.White)
        ) {
            val imageSize = 100.dp
            val boxSizeMin = imageSize * 2
            val imageOffset = imageSize / 2

            Box(
                modifier = Modifier
                    .heightIn(min = boxSizeMin, max = sizeMax)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF6200EE),
                                Color(0xFF03DAC5)
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(idImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSize)
                        .offset(x = imageOffset)
                        .align(Alignment.CenterStart)
                        .clip(shape = CircleShape)
                        .border(
                            width = 2.dp,
                            shape = CircleShape,
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF03DAC5),
                                    Color(0xFF6200EE)
                                )
                            )
                        )
                )
            }

            Spacer(modifier = Modifier.size(imageOffset))

            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                overflow = TextOverflow.Ellipsis,
                maxLines = 6,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProductKitsPreview() {
    ProductKits(
        idImage = R.drawable.placeholder,
        text = "Burger"
    )
}