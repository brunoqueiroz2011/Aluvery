package br.com.bruno.aluvery.ui.dialogs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InfoDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    AlertDialog(
        icon = {
            Icon(Icons.Default.Info, contentDescription = "Icone de Informação")
        },
        title = {
            Text(text = "Alert dialog example")
        },
        text = {
            Text(text = "This is an example of an alert dialog with buttons.")
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Fechar")
            }
        }
    )
}

@Preview
@Composable
fun InfoDialogPreview() {
    val showDialog = remember { mutableStateOf(true) }

    InfoDialog(
        onConfirmation = { showDialog.value = false },
        onDismissRequest = { showDialog.value = false },
    )
}