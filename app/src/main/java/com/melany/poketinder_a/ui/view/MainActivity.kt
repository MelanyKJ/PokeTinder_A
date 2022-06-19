package com.melany.poketinder_a.ui.view
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melany.poketinder_a.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.melany.poketinder_a.R
import com.melany.poketinder_a.data.model.PokemonDetailModel
import com.melany.poketinder_a.domian.usecase.GetMyPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import co.ankurg.expressview.OnCheckListener

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navView:BottomNavigationView= binding.navView

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

}