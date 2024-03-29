package br.com.bruno.aluvery.model

import androidx.annotation.DrawableRes
import br.com.bruno.aluvery.R
import java.math.BigDecimal

class Product(
    val name: String,
    val price: BigDecimal,
    val description: String? = null,
    val image: String? = null
) {
}