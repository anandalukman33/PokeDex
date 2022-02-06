package id.my.anandalukman.pokedex.repository

import dagger.hilt.android.scopes.ActivityScoped
import id.my.anandalukman.pokedex.data.bean.Pokemon
import id.my.anandalukman.pokedex.data.bean.PokemonList
import id.my.anandalukman.pokedex.data.remote.PokeApi
import id.my.anandalukman.pokedex.util.Resource
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(private val api: PokeApi) {
    suspend fun getPokemonList(limit: Int, offset: Int) : Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Terjadi kesalahan yang tidak diketahui")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("Terjadi kesalahan yang tidak diketahui")
        }
        return Resource.Success(response)
    }

}