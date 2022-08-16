package com.example.maplecal.symbol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maplecal.*
import com.example.maplecal.SymbolData
import com.example.maplecal.databinding.FragmentSymbolBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SymbolFragment : Fragment(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: FragmentSymbolBinding
    private lateinit var adapter: SymbolRecyclerViewAdapter
    private lateinit var symbols: Array<SymbolData>

    private val baseUrl = "https://maplestory.nexon.com"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSymbolBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {
        symbols = arrayOf(
            SymbolData(0, R.drawable.longways, "소멸의 여로", "미니게임\n(0 or 1)", "1", "1", "1"),
            SymbolData(1, R.drawable.chuchu, "츄츄 아일랜드", "미니게임\n(0 or 1)", "1", "1", "1"),
            SymbolData(2, R.drawable.lehlne, "레헬른", "드브 층수", "1", "1", "0"),
            SymbolData(3, R.drawable.arcana, "아르카나", "스세 점수", "1", "1", "30000"),
            SymbolData(4, R.drawable.moras, "모라스", "미니게임\n(0 or 1)", "1", "1", "1"),
            SymbolData(5, R.drawable.espa, "에스페라", "미니게임\n(0 or 1)", "1", "1", "1"),
            SymbolData(6, R.drawable.cernium, "세르니움", "세르니움(후)\n(0 or 1)", "1", "1", "1"),
            SymbolData(7, R.drawable.arx, "아크르스", "", "1", "1", "0")
        )
        initSymbolRecyclerView(savedInstanceState)
        initSymbolCheckBox()
        initButton()
    }

    private fun initSymbolRecyclerView(savedInstanceState: Bundle?) {
        adapter = SymbolRecyclerViewAdapter()
        if (savedInstanceState != null) {
            val data = mutableListOf<SymbolData>()
            val saveData = savedInstanceState.getParcelableArrayList<SymbolData>("symbolData")
            if (saveData != null) {
                for (i in 0 until saveData.size) {
                    data.add(saveData[i])
                }
            }
            adapter.datalist = data
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun initSymbolCheckBox() {
        binding.symbolLongways.setOnCheckedChangeListener(this)
        binding.symbolChuchu.setOnCheckedChangeListener(this)
        binding.symbolLehlne.setOnCheckedChangeListener(this)
        binding.symbolArcana.setOnCheckedChangeListener(this)
        binding.symbolMoras.setOnCheckedChangeListener(this)
        binding.symbolEspa.setOnCheckedChangeListener(this)
        binding.symbolCernium.setOnCheckedChangeListener(this)
        binding.symbolArx.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(checkBox: CompoundButton, isChecked: Boolean) {
        val symbol = when (checkBox.id) {
            R.id.symbol_longways -> 0
            R.id.symbol_chuchu -> 1
            R.id.symbol_lehlne -> 2
            R.id.symbol_arcana -> 3
            R.id.symbol_moras -> 4
            R.id.symbol_espa -> 5
            R.id.symbol_cernium -> 6
            R.id.symbol_arx -> 7
            else -> return
        }

        when (isChecked) {
            true -> adapter.addItem(symbols[symbol], symbol)
            false -> adapter.removeItem(symbol)
        }
    }

    fun initButton() {
        binding.calButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelableArrayList("symbol", ArrayList(adapter.datalist))
            val dialog = SymbolDialog()
            dialog.isCancelable = false
            dialog.arguments = bundle
            dialog.show(childFragmentManager, "Symbol Dialog")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("symbolData", ArrayList(adapter.datalist))
    }

    companion object {
        const val TAG = "SymbolFragment"

        @JvmStatic
        fun newInstance() = SymbolFragment()
    }
}