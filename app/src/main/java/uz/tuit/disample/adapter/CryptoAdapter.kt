package uz.tuit.disample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.tuit.disample.R
import uz.tuit.disample.model.CryptoCurrency

class CryptoAdapter : RecyclerView.Adapter<CryptoViewHolder>() {

    private val diffItemCallback = object : DiffUtil.ItemCallback<CryptoCurrency>() {
        override fun areItemsTheSame(oldItem: CryptoCurrency, newItem: CryptoCurrency) =
            oldItem.name == newItem.name


        override fun areContentsTheSame(oldItem: CryptoCurrency, newItem: CryptoCurrency) =
            oldItem == newItem

    }

    val differ = AsyncListDiffer(this, diffItemCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val imageView: ImageView = holder.itemView.findViewById(R.id.image_view)
        val textView: TextView = holder.itemView.findViewById(R.id.text_view)
        Glide.with(holder.itemView).load(differ.currentList[position].image).into(imageView)
        textView.text = differ.currentList[position].name
    }

    override fun getItemCount() =
        differ.currentList.size


}