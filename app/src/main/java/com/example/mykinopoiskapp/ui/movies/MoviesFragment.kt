package com.example.mykinopoiskapp.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mykinopoiskapp.App
import com.example.mykinopoiskapp.databinding.FragmentMoviesBinding
import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.presentation.MoviesPresenter
import com.example.mykinopoiskapp.views.MoviesView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class MoviesFragment : MvpAppCompatFragment(), MoviesView {

    @Inject
    lateinit var presenterProvider: Provider<MoviesPresenter>

    private val moviesPresenter by moxyPresenter { presenterProvider.get() }

    private var _binding: FragmentMoviesBinding? = null
    private lateinit var movieAdapter: MovieAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)

        movieAdapter = MovieAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recycleMovies.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = movieAdapter
        }

        binding.textSearch.setEndIconOnClickListener {
            val movieName = binding.fieldSearch.text.toString()
            moviesPresenter.searchMovies(movieName)
        }

        return root
    }

    override fun showMoviesInfo(movies: List<Movie>) {
        movieAdapter.setMovies(movies)
    }

    override fun showSuccess(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }
}