package br.com.bruno.aluvery.ui.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.bruno.aluvery.ui.dialogs.InfoDialog

@Composable
fun ScaffoldTopBar() {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        val showDialog = remember { mutableStateOf(false) }

        if (showDialog.value) {
            InfoDialog(
                onConfirmation = { showDialog.value = false },
                onDismissRequest = { showDialog.value = false },
            )
        }

        Icon(
            imageVector = Icons.Rounded.Info,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.clickable {
                showDialog.value = true
            }
        )

        Text(
            text = "Alurery",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 22.sp
        )

        Icon(
            Icons.Rounded.ExitToApp,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.clickable {
                showDialog.value = true
            }
        )

    }
}

@Preview
@Composable
fun ScaffoldTopBarPreview() {
    ScaffoldTopBar()
}