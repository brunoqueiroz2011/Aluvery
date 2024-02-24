package br.com.bruno.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.bruno.aluvery.extensions.filterProducts
import br.com.bruno.aluvery.model.Product
import br.com.bruno.aluvery.sampledata.sampleProducts
import br.com.bruno.aluvery.sampledata.sampleSections
import br.com.bruno.aluvery.ui.components.CardProductItem
import br.com.bruno.aluvery.ui.components.ProductItem
import br.com.bruno.aluvery.ui.components.ProductsSection
import br.com.bruno.aluvery.ui.components.ProductsSectionWithDescription
import br.com.bruno.aluvery.ui.components.SearchTextField

@Composable
fun HomeScreen1(
    sections: Map<String, List<Product>>,
    searchText: String = ""
) {
    Column {
        var text by remember { mutableStateOf(searchText) }

        SearchTextField(
            searchText = text,
            onSearchChange = { newValue ->
                text = newValue
            },
            Modifier.fillMaxWidth()
                .padding(16.dp)
        )

        val searchedProducts = remember(text) {
            sampleProducts.filterProducts(text)
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (text.isBlank()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            titleSection = title,
                            products = products
                        )
                    }
                }
            } else {
                items(searchedProducts) { p ->
                    CardProductItem(
                        product = p,
                        Modifier.padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen2(
    sections: Map<String, List<Product>>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item { Spacer(Modifier) }
        for (section in sections) {
            val title = section.key
            val products = section.value
            item {
                ProductsSectionWithDescription(titleSection = title, products = products)
            }
        }
        item { Spacer(Modifier) }
    }
}

@Composable
fun HomeScreenLazyGrid(
    products: List<Product>
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
    ) {
        Text(
            text = "Todos os Produtos",
            fontSize = 25.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products) { product ->
                ProductItem(product = product)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun HomeScreen1Preview() {
    HomeScreen1(sampleSections)
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenWithSearchTextPreview() {
    HomeScreen1(sampleSections, searchText = "a")
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreen2Preview() {
    HomeScreen2(sampleSections)
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenLazyGridPreview() {
    HomeScreenLazyGrid(sampleProducts)
}