package com.johan.septian.myberitacnn.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johan.septian.myberitacnn.DetailCovid
import com.johan.septian.myberitacnn.R
import com.johan.septian.myberitacnn.model.DataCovid
import kotlinx.android.synthetic.main.item_covid.view.*

class CovidAdapter(private val context: Context?, private val listCovid : List<DataCovid>): RecyclerView.Adapter<CovidAdapter.CovidHolder>() {
    class CovidHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        fun bind(item: DataCovid) {
            with(itemView) {
                itemNamaProvinsi.text = item.provinsi
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) :CovidHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_covid, viewGroup, false)
        return CovidHolder(view)
    }

    override fun onBindViewHolder(holder: CovidHolder, position: Int) {
        holder.bind(listCovid[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailCovid::class.java)
            intent.putExtra(DetailCovid.EXTRA_DATA, listCovid[position])
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listCovid.size

}