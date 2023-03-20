package com.diagnal.diagnalprogramingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.diagnal.diagnalprogramingapp.databinding.ActivityMainBinding
import com.diagnal.diagnalprogramingapp.utils.RecyclerItemClickListener
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), RecyclerItemClickListener.OnRecyclerClickListener {
    private val TAG = "MainActivity"
    private val viewModel: MainViewModel by inject()
    private val recyclerViewAdapter = MainRecyclerViewAdapter(ArrayList())
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerView.adapter = recyclerViewAdapter
            recyclerView.addOnItemTouchListener(
                RecyclerItemClickListener(
                    this@MainActivity,
                    recyclerView,
                    this@MainActivity
                )
            )
        }
        observeFromViewModal()
        viewModel.fetchCards(this)
    }
    private fun observeFromViewModal() {
        viewModel.cards.observe(this) { cards ->
            recyclerViewAdapter.loadData(cards)
        }
    }

    override fun onItemPress(view: View, position: Int) {
        Log.d(TAG, "The tapped position: $position")
    }
}