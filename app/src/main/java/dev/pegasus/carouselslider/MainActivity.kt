package dev.pegasus.carouselslider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.pegasus.carouselslider.adapter.AdapterCarousel
import dev.pegasus.carouselslider.dataProvider.DpData
import dev.pegasus.carouselslider.databinding.ActivityMainBinding
import dev.pegasus.carouselslider.extensions.ViewPagerExtensions.addCarouselEffect

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { AdapterCarousel() }
    private val dpData by lazy { DpData() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViewPager()
    }

    private fun initViewPager() {
        binding.viewPager.addCarouselEffect()
        binding.viewPager.adapter = adapter
        adapter.submitList(dpData.dummyData)
    }
}