package br.com.bruno.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.bruno.aluvery.sampledata.sampleSections
import br.com.bruno.aluvery.sampledata.sampleStoreSections
import br.com.bruno.aluvery.ui.screens.HomeScreen1


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen1(
                sections = sampleSections,
            )
        }
    }
}
