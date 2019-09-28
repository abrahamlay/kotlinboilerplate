package com.abrahamlay.kotlinboilerplate.detail

import android.os.Bundle
import androidx.core.content.ContextCompat
import android.view.*
import com.abrahamlay.common.base.BaseFragment
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.kotlinboilerplate.R
import com.abrahamlay.kotlinboilerplate.localdb.MovieDatabase
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : BaseFragment() {


    private var isFavorite: Boolean = false
    private var menuInflater: Menu? = null
    private lateinit var detailMovie: MovieModel

    companion object {
        fun newInstance(detailMovie: MovieModel): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putSerializable(PARAM_DETAIL_MOVIE, detailMovie)
            fragment.arguments = args
            return fragment
        }

        private const val PARAM_DETAIL_MOVIE: String = "DETAIL_MOVIE"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            detailMovie = arguments!!.getSerializable(PARAM_DETAIL_MOVIE) as MovieModel
        }
        setHasOptionsMenu(true)
        favoriteState()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(detailMovie)
    }

    private fun initView(detailMovie: MovieModel) {
        tvOverviewText.text = detailMovie.overview
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.menu_item_detail, menu)
        menuInflater = menu
        setFavorite()
    }

    private fun setFavorite() {
        menuInflater.let {
            if (isFavorite) {
                menuInflater?.getItem(0)?.icon =
                    ContextCompat.getDrawable(context!!, R.drawable.ic_menu_favorite_fill_white)
            } else {
                menuInflater?.getItem(0)?.icon =
                    ContextCompat.getDrawable(context!!, R.drawable.ic_menu_favorite_blank_white)
            }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_favorite -> {
                if (isFavorite)
                    removeFromFavorite()
                else
                    addToFavorite()

                isFavorite = !isFavorite
                setFavorite()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun favoriteState() {
        isFavorite = MovieDatabase.getMovie(context!!, detailMovie.id) != null
    }

    private fun addToFavorite() {
        MovieDatabase.upsertData(context!!, detailMovie)
    }

    private fun removeFromFavorite() {
        MovieDatabase.deleteData(context!!, detailMovie)
    }

}
