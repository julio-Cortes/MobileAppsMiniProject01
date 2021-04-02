package com.example.navtest

import java.text.NumberFormat
import java.util.*
import kotlin.random.Random


data class Spend(
        val totalAmount: Long,
        val categoryTitle: String,
        val totalSpends: Int
){
    fun getAmountFormat(): String {
        val format = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = Currency.getInstance("CLP")
        return format.format(this.totalAmount)
    }
}

fun spendsFactory(number: Int): List<Spend> {
    val spends = mutableListOf<Spend>()
    val categories = listOf("bottle cap", "monitor", "charger", "soy sauce packet", "nail clippers", "drill press", "sofa", "tissue box", "bag", "fake flowers", "glow stick", "soap", "twister", "toothbrush", "video games", "rubber duck", "towel", "money", "milk", "rusty nail", "house", "toe ring", "pillow", "bananas", "mouse pad", "chair", "credit card", "doll", "screw", "thread", "flowers", "drawer", "pen", "paper", "magnet", "tomato", "glasses", "spoon", "chalk", "eraser", "eye liner", "cork", "button", "spring", "mp3 player", "tree", "car", "food", "bottle", "toilet", "ice cube tray", "nail file", "hanger", "bookmark", "bowl", "needle", "stop sign", "ring", "leg warmers", "plate", "headphones", "socks", "shoes", "lace", "shawl", "cinder block", "television", "bed", "water bottle", "fork", "tooth picks", "pencil", "bow", "candy wrapper", "cup", "sharpie", "clothes", "bracelet", "brocolli", "grid paper", "chocolate", "clamp", "helmet", "lamp shade", "rug", "lamp", "hair brush", "teddies", "shampoo", "speakers", "wallet", "lip gloss", "phone", "remote", "boom box", "beef", "picture frame", "shoe lace", "floor")
    for (i in 1..number) {
        spends.add(Spend(Random.nextLong(1000, 9999999), categories.random(), Random.nextInt(1, 999)))
    }
    return spends
}


