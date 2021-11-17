package yayasan.idn.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import yayasan.idn.newsapp.databinding.ActivityMainBinding
import yayasan.idn.newsapp.packages.SectionPagerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.vpNews.adapter = SectionPagerAdapter(this)

        val tabList = arrayOf("All News","Top","Popular")
        TabLayoutMediator(binding.tabs,binding.vpNews){tabs,position ->
            tabs.text = tabList[position]
        }.attach()
    }
}