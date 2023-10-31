package com.example.hw6exercise2new

import androidx.lifecycle.ViewModel
import java.util.*



//Where I think the error is coming from, but im not sure...
    class CrimeListViewModel : ViewModel() {

        val crimes = mutableListOf<Crime>()

        init {
            for (i in 0 until 100) {
                val crime = Crime(
                    id = UUID.randomUUID(),
                    title ="Crime #$i",
                    date = Date(),
                    isSolved = i % 2 == 0,
                    requiresPolice = i % 2 == 0,
                )

                crimes += crime
            }
        }
    }

