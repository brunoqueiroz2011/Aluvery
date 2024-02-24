package br.com.bruno.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.bruno.aluvery.R
import br.com.bruno.aluvery.extensions.toBrazilianCurrency
import br.com.bruno.aluvery.model.Product
import br.com.bruno.aluvery.sampledata.sampleProducts
import br.com.bruno.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    expanded: Boolean = false
) {
    var expandedState by remember {
        mutableStateOf(expanded)
    }

    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable { expandedState = !expandedState },
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation
        )
    ) {


        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toBrazilianCurrency()
                )
            }

            val textOverflow =
                if (expandedState) TextOverflow.Visible
                else TextOverflow.Ellipsis
            val maxLines =
                if (expandedState) Int.MAX_VALUE
                else 2

            product.description?.let {
                Text(
                    text = it,
                    Modifier
                        .padding(16.dp),
                    maxLines = maxLines,
                    overflow = textOverflow
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts[2],
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemWithDescriptionPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts.first(),
                expanded = true
            )
        }
    }
}