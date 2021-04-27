package com.example.pokedex

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder


class FindByNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.find_by_name)
        val getPokeButton = findViewById<SearchView>(R.id.search_poke)
        getPokeButton.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(s: String): Boolean {
                return true
            }

            override fun onQueryTextSubmit(s: String): Boolean {
                val pokemon = Pokemon()
                val queue = Volley.newRequestQueue(this@FindByNameActivity)
                val url = "https://pokeapi.co/api/v2/pokemon/" + getPokeButton.query
                val stringRequest = makeRequestToApi(url)
                queue.add(stringRequest)
                return true
            }
        })
    }

    private fun makeRequestToApi(url: String): StringRequest {
        return StringRequest(Request.Method.GET, url,
            { response ->
                val result = requestResult(response)
                val i = putPokemonDataInIntent(result)
                startActivity(i);
            },
            {
                showErrorMessagePokemonNotFind()
            })

    }

    private fun showErrorMessagePokemonNotFind() {
        Toast.makeText(
            getApplicationContext(),
            "Pokemon não existe",
            Toast.LENGTH_LONG
        )
            .show()
    }

    private fun putPokemonDataInIntent(result: Pokemon?): Intent {
        val i = Intent(this@FindByNameActivity, PokemonResult::class.java)
        i.putExtra("pokemonName", result?.name.toString())
        i.putExtra("pokemonId", result?.id)
        i.putExtra("pokemonImage", result?.sprites?.front_default.toString())
        i.putExtra("pokemonPcpType", result?.types?.get(0)?.type?.name.toString())
        return i
    }

    private fun requestResult(response: String): Pokemon? {
        return  GsonBuilder().create().fromJson(response.toString(), Pokemon::class.java)
    }

}