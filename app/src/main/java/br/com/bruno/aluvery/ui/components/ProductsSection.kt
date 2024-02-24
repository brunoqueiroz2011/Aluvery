package br.com.bruno.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.bruno.aluvery.model.Product
import br.com.bruno.aluvery.sampledata.sampleProducts
import br.com.bruno.aluvery.ui.theme.AluveryTheme

@Composable
fun ProductsSection(
    titleSection: String = "",
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    Section(
        title = {
            Text(
                text = titleSection,
                fontSize = 20.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        },
        content = {
            LazyRow(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(products){product->
                    ProductItem(product = product)
                }
            }
        },
        modifier = modifier
    )
}

@Composable
fun ProductsSectionWithDescription(
    titleSection: String = "",
    products: List<Product>
) {
    Column {
        Text(
            text = titleSection,
            fontSize = 20.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products){product ->
                ProductItem(product = product)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductsSectionPreview() {
    AluveryTheme {
        Surface {
            ProductsSection("Promoções", products = sampleProducts)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsSectionWithDescriptionPreview() {
    AluveryTheme {
        Surface {
            ProductsSectionWithDescription(titleSection = "Preview", products = sampleProducts)
        }
    }
}
