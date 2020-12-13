package com.johan.septian.myberitacnn.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.johan.septian.myberitacnn.DetailActivity
import com.johan.septian.myberitacnn.R
import com.johan.septian.myberitacnn.model.ItemNews
import kotlinx.android.synthetic.main.item_news.view.*

class BeritaAdapter(private val context: Context?, private val listItem : List<ItemNews>): RecyclerView.Adapter<BeritaAdapter.NewsHolder>() {
    class NewsHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        fun bind(item: ItemNews) {
            with(itemView) {
                Glide.with(context)
                    .load(item.poster)
                    .into(itemImgBerita)
                itemJudulBerita.text = item.judul
                itemWaktuBerita.text = item.waktu
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_news, viewGroup, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(listItem[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_URL, listItem[position])
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listItem.size
}