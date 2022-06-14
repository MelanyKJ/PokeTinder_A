package com.melany.poketinder_a.ui.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.melany.poketinder_a.databinding.FragmentFavoriteBinding
import com.melany.poketinder_a.domian.model.MyPokemon
import com.melany.poketinder_a.ui.adapter.MyPokemonsAdapter
import com.melany.poketinder_a.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {
    private var listMyPokemon = mutableListOf<MyPokemon>()
    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon)}
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
        binding.rvPokemons.adapter = adapter

        viewModel.myPokemonList.observe(this){
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
}

/*
    companion object {
        fun newInstance() = FavoriteFragment()
    }

    private lateinit var viewModel: FavoriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
        // TODO: Use the ViewModel
    }
 */