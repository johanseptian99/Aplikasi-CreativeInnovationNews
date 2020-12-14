package com.johan.septian.myberitacnn

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.johan.septian.myberitacnn.adapter.OnBoardingViewPagerAdapter
import com.johan.septian.myberitacnn.model.OnBoardingData

class MainBoarding : AppCompatActivity() {
    var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter? = null
    var tabLayout: TabLayout? = null
    var onBoardingViewPager : ViewPager? = null
    var next : TextView? = null
    var position = 0
    var sharedPreferences : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (restorePrefData()){
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        setContentView(R.layout.activity_main_boarding)

        tabLayout = findViewById(R.id.tab_indicator)
        next = findViewById(R.id.next_TextView)

        val onBoardingData : MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData("judul1","deskripsi1",R.drawable.intro1))
        onBoardingData.add(OnBoardingData("judul2","deskripsi2",R.drawable.intro2))
        onBoardingData.add(OnBoardingData("judul3","deskripsi3",R.drawable.intro3))

        setOnBoardingViewPagerAdapter(onBoardingData)
        position = onBoardingViewPager!!.currentItem
        next?.setOnClickListener {
            if (position < onBoardingData.size){
                position++
                onBoardingViewPager!!.currentItem = position
            }
            if (position == onBoardingData.size){
                savePrefData()
                val i = Intent(applicationContext, MainActivity::class.java)
                startActivity(i)
            }
        }

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                position = tab!!.position
                if(tab.position == onBoardingData.size -1){
                    next!!.text = getString(R.string.GetStarted)
                }else{
                    next!!.text = getString(R.string.Next)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }

    private fun setOnBoardingViewPagerAdapter(onBoardingData: List<OnBoardingData>){
        onBoardingViewPager = findViewById(R.id.screenPager)
        onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this, onBoardingData)
        onBoardingViewPager!!.adapter = onBoardingViewPagerAdapter
        tabLayout?.setupWithViewPager(onBoardingViewPager)
    }

    private fun savePrefData(){
        sharedPreferences = applicationContext.getSharedPreferences("Pref", MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }

    private fun restorePrefData(): Boolean{
        sharedPreferences = applicationContext.getSharedPreferences("Pref", MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun", false)
    }

}