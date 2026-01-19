package com.example.fragmentsimenus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsimenus.databinding.FragmentSegonBinding


class SegonFragment : Fragment() {
    // Declaro el binding específic per al disseny del segon fragment
    lateinit var binding: FragmentSegonBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // --- Creació de la Vista ---
        // Converteixo el fitxer fragment_segon.xml en codi.
        binding = FragmentSegonBinding.inflate(inflater, container, false)
        // Retorno l'arrel perquè Android la mostri per pantalla.
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Assignació de Dades ---
        // Recupero les dades del "Bundle" i les poso als TextViews corresponents.
        // Utilitzo les mateixes claus ("titolKey", etc.) que vaig definir a la MainActivity.
        // Si no poso bé les claus com les del MainActivity donara error.

        binding.tvTitol.text = arguments?.getString("titolKey")
        binding.tvEntitat.text = arguments?.getString("entitatKey")
        binding.tvAnyAssoliment.text = arguments?.getString("anyAssolimentKey")
        
        binding.tvTitol2.text = arguments?.getString("titol2Key")
        binding.tvEntitat2.text = arguments?.getString("entitat2Key")
        binding.tvAnyAssoliment2.text = arguments?.getString("anyAssoliment2Key")
    }
}