package com.example.fragmentsimenus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsimenus.databinding.FragmentTercerBinding


class TercerFragment : Fragment() {
    // Binding per al tercer fragment (Experiència Laboral)
    lateinit var binding: FragmentTercerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // --- Creació de la Vista ---
        // Inflo el layout 'fragment_tercer.xml'.
        binding = FragmentTercerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Visualització de la Informació ---
        // Agafo els textos que m'envien del MainActivity (experiència, tipus, període) i els "pinto" a la pantalla.
        
        binding.tvExperiencia.text = arguments?.getString("experienciaKey")
        binding.tvTipus.text = arguments?.getString("tipusKey")
        binding.tvPeriode.text = arguments?.getString("periodeKey")
        
        binding.tvExperiencia2.text = arguments?.getString("experiencia2Key")
        binding.tvTipus2.text = arguments?.getString("tipus2Key")
        binding.tvPeriode2.text = arguments?.getString("periode2Key")
    }
}