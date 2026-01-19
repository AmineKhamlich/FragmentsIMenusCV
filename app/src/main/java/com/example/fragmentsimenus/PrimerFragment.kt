package com.example.fragmentsimenus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsimenus.databinding.FragmentPrimerBinding

class PrimerFragment : Fragment() {

    // Variable per accedir als elements del XML d'aquest fragment
    lateinit var binding: FragmentPrimerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // --- Creació de la Vista ---
        // Aquí "inflo" el XML d'aquest fragment.
        // Important: En Fragments NO utilitzo setContentView. He de retornar la vista creada aquí.
        binding = FragmentPrimerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Lògica del Fragment ---
        // Aquest mètode s'executa quan la vista JA existeix.

        // 1. Recupero les dades:
        // Utilitzo "arguments?.getString(...)" per obrir el paquet que m'ha enviat la MainActivity.
        // 2. Assigno les dades:
        // Poso el text recuperat directament dins dels TextViews del meu disseny.
        
        binding.tvNom.text = arguments?.getString("NomKey") // Busco el valor amb l'etiqueta "NomKey"
        binding.tvCognoms.text = arguments?.getString("CognomsKey")
        binding.tvData.text = arguments?.getString("DataKey")
        binding.tvLloc.text = arguments?.getString("LlocKey")

    }

}