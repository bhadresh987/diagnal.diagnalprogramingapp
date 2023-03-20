package com.diagnal.diagnalprogramingapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diagnal.diagnalprogramingapp.databinding.MoviePosterBinding
import com.diagnal.diagnalprogramingapp.models.Content
import com.diagnal.diagnalprogramingapp.utils.toDrawable

class MainRecyclerViewAdapter(private var posters: List<Content>) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.PosterViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun loadData(newPoster: List<Content>) {
        posters = newPoster
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PosterViewHolder =
        PosterViewHolder(
            MoviePosterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(
        holder: PosterViewHolder,
        position: Int
    ) {
        holder.bind(posters[position])
    }

    inner class PosterViewHolder(private val binding: MoviePosterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dataMode: Content) = with(binding) {
            val poster = posters[position]

            val image: List<String> = poster.posterImage.split(".")
            if (image.isNotEmpty()) {
                imageView.setImageResource(image[0].toDrawable(itemView.context))
            }
            textViewTitle.text = poster.name
        }
    }

    override fun getItemCount(): Int {
        return posters.size
    }
}