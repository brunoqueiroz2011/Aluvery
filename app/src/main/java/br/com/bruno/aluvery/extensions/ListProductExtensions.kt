package br.com.bruno.aluvery.extensions

import br.com.bruno.aluvery.model.Product
import br.com.bruno.aluvery.sampledata.sampleProducts

fun List<Product>.filterProducts(text: String): List<Product> {
    return if (text.isNotBlank()) {
        sampleProducts.filter { product ->
            product.name.contains(
                text,
                ignoreCase = true,
            ) ||
                    product.description?.contains(
                        text,
                        ignoreCase = true,
                    ) ?: false
        }
    } else emptyList()
}