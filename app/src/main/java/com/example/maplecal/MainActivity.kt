package com.example.maplecal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.example.maplecal.symbol.SymbolFragment
import com.example.maplecal.databinding.ActivityMainBinding
import com.example.maplecal.growth.GrowthFragment
import com.example.maplecal.hyper.HyperFragment
import com.example.maplecal.park.ParkFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val symbolFragment by lazy { SymbolFragment.newInstance() }
    private val parkFragment by lazy { ParkFragment.newInstance() }
    private val hyperFragment by lazy { HyperFragment.newInstance() }
    private val growthFragment by lazy { GrowthFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMain)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.maplecal)

        initNavigationBar()
        if (savedInstanceState == null) {
            binding.bvnMain.selectedItemId = R.id.symbol_item
        }
    }

    private fun initNavigationBar() {
        binding.bvnMain.run {
            itemIconTintList = null
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.symbol_item -> {
                        changeFragment(symbolFragment, SymbolFragment.TAG)
                    }
                    R.id.park_item -> {
                        changeFragment(parkFragment, ParkFragment.TAG)
                    }
                    R.id.hyper_item -> {
                        changeFragment(hyperFragment, HyperFragment.TAG)
                    }
                    R.id.growth_item -> {
                        changeFragment(growthFragment, GrowthFragment.TAG)
                    }
                }
                true
            }
        }
    }

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment, tag)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }
}