package com.example.pokedex

data class Pokemon (
        var name: String? = null,
        var id: String? = null ,
        var types: Array<Types>? = null,
        var sprites: Sprites? = null
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pokemon

        if (name != other.name) return false
        if (id != other.id) return false
        if (types != null) {
            if (other.types == null) return false
        } else if (other.types != null) return false
        if (sprites != other.sprites) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + id.hashCode()
        result = 31 * result + (types?.contentHashCode() ?: 0)
        result = 31 * result + (sprites?.hashCode() ?: 0)
        return result
    }
}

data class Types (
    var slot : Number =0,
    var type: PokemonType? = null
)

data class PokemonType(
        var name: String? = null,
        var url: String? = null
)

data class Sprites(
        var front_default : String? = null
)







