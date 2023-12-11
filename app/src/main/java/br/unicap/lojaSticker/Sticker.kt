package br.unicap.lojasticker

data class Sticker(
    val name: String,
    val image: Int,
    val price: Double,
    var qtd : Int = 1
) {
    companion object {
        val price: Any
            get() {
                return price
            }
    }
}