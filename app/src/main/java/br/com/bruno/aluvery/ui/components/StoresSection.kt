package br.com.bruno.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.bruno.aluvery.model.Product
import br.com.bruno.aluvery.model.Store

@Composable
fun StoreSection(
    titleSection: String = "",
    stores: List<Store>,
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
                items(stores){store->
                    StoreItem(store = store)
                }
            }
        },
        modifier = modifier
    )
}