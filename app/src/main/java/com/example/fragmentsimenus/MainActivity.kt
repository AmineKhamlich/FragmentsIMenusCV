package com.example.fragmentsimenus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentsimenus.databinding.ActivityMainBinding
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {

    // Declaro la variable del binding.
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // --- Inicialitzo el ViewBinding ---
        // "Inflo" el disseny de l'activitat per convertir el XML en codi Kotlin utilitzable.
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Estableixo aquesta vista com la interfície per l'usuari.
        setContentView(binding.root)

        // Configuro el "listener" del menú inferior.
        // Això serveix perquè l'app sàpiga què fer quan clico a cada icona del menú.
        binding.navMenu.setOnItemSelectedListener {
            when (it.itemId) {
                // Si l'usuari clica el primer botó...
                R.id.itemFragment1 -> {
                    // 1. Preparo les dades:
                    // Creo un "Bundle" (una caixa) on guardo la meva informació personal (Nom, Cognoms, etc).
                    // Utilitzo claus com "NomKey" per poder recuperar-ho després al fragment.
                    val bundle = bundleOf(
                        "NomKey" to "Amine",
                        "CognomsKey" to "Khamlich",
                        "DataKey" to "13/06/1990",
                        "LlocKey" to "Casablanca"
                    )
                    // 2. Canvio el fragment:
                    // Utilitzo el FragmentManager per substituir el que hi hagi en pantalla pel "PrimerFragment".
                    // Li passo el 'bundle' que acabo de crear perquè el fragment rebi les dades.
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(R.id.fragmentContainer, PrimerFragment().apply { arguments = bundle })
                    }
                    return@setOnItemSelectedListener true
                }
                // Si l'usuari clica el segon botó...
                R.id.itemFragment2 -> {
                    // Repeteixo el procés de preparació de dades.

                    val bundle = bundleOf(
                        "titolKey" to "CFGM IEA",
                        "entitatKey" to "IOC",
                        "anyAssolimentKey" to "2020",
                        "titol2Key" to "CFGS DAM",
                        "entitat2Key" to "IES Rafael Campalans",
                        "anyAssoliment2Key" to "2026"
                    )
                    // I substitueixo el fragment actual pel "SegonFragment", enviant-li les dades.
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(R.id.fragmentContainer, SegonFragment().apply { arguments = bundle })
                    }
                    return@setOnItemSelectedListener true
                }
                // Si l'usuari clica el tercer botó...
                R.id.itemFragment3 -> {
                    // Preparo el Bundle amb  les dades com a abans.
                    // I substitueixo el fragment actual pel "TercerFragment", enviant-li les dades.
                    val bundle = bundleOf(
                        "experienciaKey" to "Electromecanic",
                        "tipusKey" to "Manteniment",
                        "periodeKey" to "2029-2024",
                        "experiencia2Key" to "Programador industrial",
                        "tipus2Key" to "Programador",
                        "periode2Key" to "2025-Actualment"
                    )
                    // Mostro el TercerFragment.
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(R.id.fragmentContainer, TercerFragment().apply { arguments = bundle })
                    }
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

        // --- Càrrega Inicial ---
        // Com que quan obro l'app encara no he clicat res, he de carregar el primer fragment manualment.
        // Si no fes això, la pantalla sortiria buida al principi.
        
        val bundle = bundleOf(
            "NomKey" to "Amine",
            "CognomsKey" to "Khamlich",
            "DataKey" to "13/06/1990",
            "LlocKey" to "Casablanca"
        )

        // Mostro el primer fragment.
        // Li passo el 'bundle' que acabo de crear perquè el fragment rebi les dades.
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<PrimerFragment>(R.id.fragmentContainer, args = bundle)
        }
    }
}
