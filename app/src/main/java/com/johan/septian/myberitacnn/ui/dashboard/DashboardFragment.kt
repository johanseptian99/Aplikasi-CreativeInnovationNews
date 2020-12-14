package com.johan.septian.myberitacnn.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.johan.septian.myberitacnn.BeritaPerkategori
import com.johan.septian.myberitacnn.DetailActivity
import com.johan.septian.myberitacnn.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)



        root.cardCategoryNasional.setOnClickListener {
            val intent = Intent(context, BeritaPerkategori::class.java)
            intent.putExtra("data", "Nasional")
            startActivity(intent)
            Toast.makeText(context, "Membuka Berita Nasional", Toast.LENGTH_SHORT).show()
        }

        root.cardCategoryInternasional.setOnClickListener {
            val intent = Intent(context, BeritaPerkategori::class.java)
            intent.putExtra("data", "Internasional")
            startActivity(intent)
            Toast.makeText(context, "Membuka Berita Internasional", Toast.LENGTH_SHORT).show()
        }

        root.cardCategoryEkonomi.setOnClickListener {
            val intent = Intent(context, BeritaPerkategori::class.java)
            intent.putExtra("data", "Ekonomi")
            startActivity(intent)
            Toast.makeText(context, "Membuka Berita Ekonomi", Toast.LENGTH_SHORT).show()
        }

        root.cardCategoryOlahRaga.setOnClickListener {
            val intent = Intent(context, BeritaPerkategori::class.java)
            intent.putExtra("data", "OR")
            startActivity(intent)
            Toast.makeText(context, "Membuka Berita Olahraga", Toast.LENGTH_SHORT).show()
        }

        root.cardCategoryTeknologi.setOnClickListener {
            val intent = Intent(context, BeritaPerkategori::class.java)
            intent.putExtra("data", "Teknologi")
            startActivity(intent)
            Toast.makeText(context, "Membuka Berita Teknologi", Toast.LENGTH_SHORT).show()
        }

        root.cardCategoryHiburan.setOnClickListener {
            val intent = Intent(context, BeritaPerkategori::class.java)
            intent.putExtra("data", "Hiburan")
            startActivity(intent)
            Toast.makeText(context, "Membuka Berita Hiburan", Toast.LENGTH_SHORT).show()
        }

        root.cardCategoryGayaHidup.setOnClickListener {
            val intent = Intent(context, BeritaPerkategori::class.java)
            intent.putExtra("data", "GH")
            startActivity(intent)
            Toast.makeText(context, "Membuka Berita Gaya Hidup", Toast.LENGTH_SHORT).show()
        }

        return root
    }
}