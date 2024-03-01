package br.com.bruno.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import br.com.bruno.aluvery.sampledata.sampleSections
import br.com.bruno.aluvery.sampledata.sampleStoreSections
import br.com.bruno.aluvery.ui.scaffold.ScaffoldTopBar
import br.com.bruno.aluvery.ui.screens.HomeScreen1


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    ScaffoldTopBar()
                }
            ) {
                Box(
                    modifier = Modifier.padding(it)
                ){
                    HomeScreen1(
                        sections = sampleSections,
                    )
                }
            }

        }
    }
}
