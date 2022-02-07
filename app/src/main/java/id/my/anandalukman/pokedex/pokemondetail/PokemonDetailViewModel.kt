package id.my.anandalukman.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import id.my.anandalukman.pokedex.data.bean.Pokemon
import id.my.anandalukman.pokedex.repository.PokemonRepository
import id.my.anandalukman.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}