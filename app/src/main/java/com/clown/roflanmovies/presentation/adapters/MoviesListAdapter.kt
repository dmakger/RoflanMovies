package com.clown.roflanmovies.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clown.roflanmovies.domain.model.Movie
import com.clown.roflanmovies.R
import kotlinx.android.synthetic.main.listitem_movie.view.*

class MoviesListAdapter(private val listener: Listener) : RecyclerView.Adapter<MoviesListAdapter.MyViewHolder>() {

    private val list = mutableListOf<Movie>()

    interface Listener {
        fun onItemClick(poster: Movie)
    }

    inner class MyViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.listitem_movie, parent, false)
    ) {
        fun bind(movie: Movie) = with(itemView) {
            imgPoster.setImageBitmap(movie.img)

            setOnClickListener { listener.onItemClick(movie) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(parent)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun addItem(movie: Movie) {
        list.add(movie)
        notifyItemInserted(list.lastIndex)
    }
}