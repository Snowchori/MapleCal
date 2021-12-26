package com.example.maplecal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.example.maplecal.databinding.ActivityMainBinding
import com.example.maplecal.fragment.*

class MainActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    private val symbolFragment by lazy { SymbolFragment() }
    private val parkFragment by lazy { ParkFragment() }
    private val hyperFragment by lazy { HyperFragment() }
    private val trainFragment by lazy { TrainFragment() }
    private val growthFragment by lazy { GrowthFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // tool bar
        setSupportActionBar(binding.toolbarMain)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "메이플 계산기"

        // bottom navigation bar
        initNavigationBar()
    }

    private fun initNavigationBar() {
        binding.bvnMain.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.symbolF -> {
                        changeFragment(symbolFragment)
                    }
                    R.id.parkF -> {
                        changeFragment(parkFragment)
                    }
                    R.id.hyperF -> {
                        changeFragment(hyperFragment)
                    }
                    R.id.trainF -> {
                        changeFragment(trainFragment)
                    }
                    R.id.growthF -> {
                        changeFragment(growthFragment)
                    }
                }
                true
            }
            selectedItemId = R.id.symbolF
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}