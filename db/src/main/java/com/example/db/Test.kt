package com.example.db

class Test {
    suspend fun insertSamplePokemons(dao: PokeDao) {
        val samplePokemons = listOf(
            PokemonEntity(
                id = 1,
                name = "Bulbasaur",
                height = 7,
                weight = 69,
                abilitiesJson = "[{\"ability\":{\"name\":\"overgrow\",\"url\":\"https://pokeapi.co/api/v2/ability/65/\"}}, {\"ability\":{\"name\":\"chlorophyll\",\"url\":\"https://pokeapi.co/api/v2/ability/34/\"}}]",
                typesJson = "[{\"slot\":1,\"type\":{\"name\":\"grass\",\"url\":\"https://pokeapi.co/api/v2/type/12/\"}}]",
                imagePath = "https://example.com/bulbasaur.png"
            ),
            PokemonEntity(
                id = 2,
                name = "Ivysaur",
                height = 10,
                weight = 130,
                abilitiesJson = "[{\"ability\":{\"name\":\"overgrow\",\"url\":\"https://pokeapi.co/api/v2/ability/65/\"}}, {\"ability\":{\"name\":\"chlorophyll\",\"url\":\"https://pokeapi.co/api/v2/ability/34/\"}}]",
                typesJson = "[{\"slot\":1,\"type\":{\"name\":\"grass\",\"url\":\"https://pokeapi.co/api/v2/type/12/\"}}, {\"slot\":2,\"type\":{\"name\":\"poison\",\"url\":\"https://pokeapi.co/api/v2/type/4/\"}}]",
                imagePath = "https://example.com/ivysaur.png"
            )
        )

        dao.insertPokemons(samplePokemons)
    }
}