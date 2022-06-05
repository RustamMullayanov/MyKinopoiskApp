package com.example.mykinopoiskapp.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mykinopoiskapp.App
import com.example.mykinopoiskapp.databinding.FragmentFavoritesBinding
import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.presentation.FavoritesPresenter
import com.example.mykinopoiskapp.presentation.MoviesPresenter
import com.example.mykinopoiskapp.ui.movies.MovieActivity
import com.example.mykinopoiskapp.ui.movies.MovieAdapter
import com.example.mykinopoiskapp.views.FavoritesView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class FavoritesFragment : MvpAppCompatFragment(), FavoritesView {

    @Inject
    lateinit var presenterProvider: Provider<FavoritesPresenter>

    private val favoritesPresenter by moxyPresenter { presenterProvider.get() }

    private var _binding: FragmentFavoritesBinding? = null
    private lateinit var movieAdapter: MovieAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)

        movieAdapter = MovieAdapter { id ->
            startActivity(MovieActivity.createIntent(requireContext().applicationContext, id))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recycleMovies.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = movieAdapter
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        favoritesPresenter.getFavorites()
    }

    override fun showFavoritesInfo(movies: List<Movie>) {
        movieAdapter.setMovies(movies)
    }

    override fun showSuccess(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }
}