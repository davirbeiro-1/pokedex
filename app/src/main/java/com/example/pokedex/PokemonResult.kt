package com.example.pokedex

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class PokemonResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_result)

        val intent = intent
        setPokemonNameIntoViewName(intent.getStringExtra("pokemonName"))
        setPokemonIdToViewId(intent.getStringExtra("pokemonId"))
        setPokemonTypeToViewType(intent.getStringExtra("pokemonPcpType"))
        setPokemonImageToViewImage(intent.getStringExtra("pokemonImage"))
    }

    private fun setPokemonNameIntoViewName(pokemonName: String?) {
        val pokeNameView = findViewById<TextView>(R.id.pokeName)
        pokeNameView.setText(pokemonName)
    }

    private fun setPokemonIdToViewId(pokemonId: String?) {
        val pokeIdView = findViewById<TextView>(R.id.pokeId)
        pokeIdView.setText(pokemonId)
    }

    private fun setPokemonTypeToViewType(pokemonPcpType: String?) {
        val pokePcpTypeView = findViewById<TextView>(R.id.pokeType)
        pokePcpTypeView.setText(pokemonPcpType)
    }

    private fun setPokemonImageToViewImage(pokemonImage: String?) {
        val pokeImageView = findViewById<ImageView>(R.id.pokeImage)
        Picasso.get().load(pokemonImage).into(pokeImageView)
    }

}
