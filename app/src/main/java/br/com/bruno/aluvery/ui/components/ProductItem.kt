package br.com.bruno.aluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.bruno.aluvery.R
import br.com.bruno.aluvery.extensions.toBrazilianCurrency
import br.com.bruno.aluvery.model.Product
import br.com.bruno.aluvery.ui.dialogs.InfoProductDialog
import br.com.bruno.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage
import java.math.BigDecimal

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier,
) {
    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value){
            InfoProductDialog(
                onDismissRequest = { openDialog.value = false },
                image = product.image,
                imageDescription = product.description
            )
    }

    Surface(
        modifier,
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .heightIn(min = 250.dp, max = 300.dp)
                .width(200.dp)
                .background(Color.White)
                .clickable {
                    openDialog.value = true
                }
        ) {
            val imageSize = 100.dp
            val offset = imageSize / 2
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    )
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = stringResource(
                        id = R.string.app_name
                    ),
                    modifier = Modifier
                        .size(imageSize)
                        .offset(y = offset)
                        .align(Alignment.BottomCenter)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
            }
            Spacer(modifier = Modifier.size(offset))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    modifier = Modifier.padding(8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                )
            }
        }
    }
}

@Composable
fun ProductItemWithDescription(
    product: Product
) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .heightIn(min = 250.dp, max = 260.dp)
                .width(200.dp)
                .background(Color.White)
                .verticalScroll(rememberScrollState()),
        ) {
            val imageSize = 100.dp
            val offset = imageSize / 2
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageSize)
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.placeholder
                    ),
                    contentDescription = stringResource(
                        id = R.string.app_name
                    ),
                    modifier = Modifier
                        .size(imageSize)
                        .offset(y = offset)
                        .align(Alignment.BottomCenter)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.size(offset))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    modifier = Modifier.padding(8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                )
            }
            product.description?.let {
                Text(
                    text = it,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(16.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    AluveryTheme {
        Surface {
            ProductItem(
                Product(
                    name = LoremIpsum(50).values.first(),
                    price = BigDecimal("14.99")
                )
            )
        }
    }
}
