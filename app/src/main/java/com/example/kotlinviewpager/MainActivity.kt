package com.example.kotlinviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var viewpager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupViewPager()
    }

    private fun initViews() {
        tabs = findViewById(R.id.tabs)
        viewpager = findViewById(R.id.viewpager)
    }

    private fun setupViewPager() {
        val adapter = MyFragmentPagerAdapter(getSupportFragmentManager())

        val firstFragment: MyFragment = MyFragment.newInstance("First Fragment")
        val secondFragment: MyFragment = MyFragment.newInstance("Second Fragment")
        val thirdFragment: MyFragment = MyFragment.newInstance("Third Fragment")

        adapter.addFragment(firstFragment, "ONE")
        adapter.addFragment(secondFragment, "TWO")
        adapter.addFragment(thirdFragment, "THREE")

        viewpager.adapter = adapter
        tabs.setupWithViewPager(viewpager)
    }
}
