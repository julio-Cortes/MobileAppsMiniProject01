package com.example.navtest


import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.budget_app.OnClickListener
import com.example.budget_app.R
import kotlinx.android.parcel.Parcelize
import java.text.NumberFormat
import java.util.*
import kotlin.random.Random

@Parcelize
data class Spend(
        val totalAmount: Long,
        val categoryTitle: String,
        val totalSpends: Int
): Parcelable {
    fun getAmountFormat(): String {
        val format = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = Currency.getInstance("CLP")
        return format.format(this.totalAmount)
    }
}
class SpendRecyclerViewAdapter(): RecyclerView.Adapter<SpendRecyclerViewAdapter.SpendViewHolder>(){

    var data = mutableListOf<Spend>()
    lateinit var onClickListener:OnClickListener

    inner class SpendViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bindView(item: Spend){
            val category = view.findViewById<TextView>(R.id.category_text_view)
            val amout = view.findViewById<TextView>(R.id.tota_amout_view)
            amout.text = "$ "+item.getAmountFormat()
            category.text = item.categoryTitle
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): SpendRecyclerViewAdapter.SpendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.spends_recycler_view,parent,false)
        return SpendViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpendRecyclerViewAdapter.SpendViewHolder, position: Int) {
        val item = data[position]
        holder.bindView(item)
        holder.itemView.setOnClickListener {
            onClickListener.onClickItem(item)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
    fun addOneCase(spend: Spend){
        data.add(spend)
        this.notifyDataSetChanged()
    }
    fun addFiveCases(spends: MutableList<Spend>){
        data.addAll(spends)
        this.notifyDataSetChanged()
    }



}


fun spendsFactory(number: Int): MutableList<Spend> {
    val spends = mutableListOf<Spend>()
    val categories = listOf("bottle cap", "monitor", "charger", "soy sauce packet", "nail clippers", "drill press", "sofa", "tissue box", "bag", "fake flowers", "glow stick", "soap", "twister", "toothbrush", "video games", "rubber duck", "towel", "money", "milk", "rusty nail", "house", "toe ring", "pillow", "bananas", "mouse pad", "chair", "credit card", "doll", "screw", "thread", "flowers", "drawer", "pen", "paper", "magnet", "tomato", "glasses", "spoon", "chalk", "eraser", "eye liner", "cork", "button", "spring", "mp3 player", "tree", "car", "food", "bottle", "toilet", "ice cube tray", "nail file", "hanger", "bookmark", "bowl", "needle", "stop sign", "ring", "leg warmers", "plate", "headphones", "socks", "shoes", "lace", "shawl", "cinder block", "television", "bed", "water bottle", "fork", "tooth picks", "pencil", "bow", "candy wrapper", "cup", "sharpie", "clothes", "bracelet", "brocolli", "grid paper", "chocolate", "clamp", "helmet", "lamp shade", "rug", "lamp", "hair brush", "teddies", "shampoo", "speakers", "wallet", "lip gloss", "phone", "remote", "boom box", "beef", "picture frame", "shoe lace", "floor")
    for (i in 1..number) {
        spends.add(Spend(Random.nextLong(1000, 9999999), categories.random(), Random.nextInt(1, 999)))
    }
    return spends
}


