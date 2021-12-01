package com.clown.roflanmovies

import com.clown.roflanmovies.domain.model.Movie
import com.clown.roflanmovies.json.JSONGet
import com.clown.roflanmovies.json.JSONReader
import org.json.JSONObject

class ImageJSONReader: JSONReader<Movie> {
    val URL = "https://api.npoint.io/40eb6b80fbfb57468585"
    val TAG = "movies"

    fun getList(): MutableList<Movie> {
        return parse(download())
    }

    override fun download(): String? {
        return JSONGet().execute(URL).get()
    }

    override fun parse(data: String?): MutableList<Movie> {
        val movieList = mutableListOf<Movie>()
        if (data?.isNotEmpty() == true) {
            val json = JSONObject(data)
            val jsonArray = json.getJSONArray(TAG)
            for (i in 0 until jsonArray.length())
                parseObject(jsonArray.getJSONObject(i))?.let {
                    movieList.add(it)
                }
        }

        return movieList
    }

    override fun parseObject(jsonObject: JSONObject): Movie? {
        val jsonArrayCountry = jsonObject.getJSONArray("country")
        val listCountry = mutableListOf<String>()
        for (i in 0 until jsonArrayCountry.length())
            listCountry.add(jsonArrayCountry.getString(i))

        val jsonArrayGenre = jsonObject.getJSONArray("genre")
        val listGenre = mutableListOf<String>()
        for (i in 0 until jsonArrayGenre.length())
            listGenre.add(jsonArrayGenre.getString(i))

        val jsonArrayActors = jsonObject.getJSONArray("actors")
        val listActors = mutableListOf<String>()
        for (i in 0 until jsonArrayActors.length())
            listActors.add(jsonArrayActors.getString(i))

        val jsonArrayDirection = jsonObject.getJSONArray("direction")
        val listDirection = mutableListOf<String>()
        for (i in 0 until jsonArrayDirection.length())
            listDirection.add(jsonArrayDirection.getString(i))

        return Movie(
            jsonObject.getString("id").toInt(),
            GetBitmapImageFromURL().execute(jsonObject.getString("img")).get(),
            jsonObject.getString("title"),
            listCountry,
            listGenre,
            listActors,
            jsonObject.getString("year").toInt(),
            jsonObject.getString("duration").toInt(),
            listDirection
        )
    }
}