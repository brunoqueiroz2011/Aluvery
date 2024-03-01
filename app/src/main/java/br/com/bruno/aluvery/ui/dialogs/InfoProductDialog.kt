package br.com.bruno.aluvery.ui.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import br.com.bruno.aluvery.R
import br.com.bruno.aluvery.sampledata.sampleProducts
import coil.compose.AsyncImage

@Composable
fun InfoProductDialog(
    onDismissRequest: () -> Unit,
    image: String? = null,
    imageDescription: String? = null
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = imageDescription,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(160.dp)
                        .padding(8.dp)
                        .clip(shape = RoundedCornerShape(16.dp)),
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
                if (imageDescription != null) {
                    Text(
                        text = imageDescription,
                        modifier = Modifier.padding(16.dp),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Entendi")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun InfoProductDialogPreview() {

    val openDialog = remember { mutableStateOf(true) }

    sampleProducts.first().description?.let {
        InfoProductDialog(
            onDismissRequest = { openDialog.value = false },
            image = sampleProducts.first().image,
            imageDescription = it
        )
    }
}