package com.app.test.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.test.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val photosViewModel: PhotosViewModel by viewModels()
    private val photosAdapter = PhotoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setProgress(true)
        photosRecyclerView.adapter = photosAdapter
        photosRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        photosViewModel.photosLiveData.observe(this,
            { list ->
                with(photosAdapter) {
                    setProgress(false)
                    photos.clear()
                    photos.addAll(list)
                    notifyItemRangeChanged(0, list.size)
                }
            })
    }

    private fun setProgress(isProgressOn: Boolean) {
        when(isProgressOn) {
            true -> {
                progressBar.visibility = View.VISIBLE
                photosRecyclerView.visibility = View.GONE
            }
            false -> {
                progressBar.visibility = View.GONE
                photosRecyclerView.visibility = View.VISIBLE
            }
        }
    }
}