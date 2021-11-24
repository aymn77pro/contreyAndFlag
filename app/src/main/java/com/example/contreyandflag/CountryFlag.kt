package com.example.contreyandflag

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.contreyandflag.databinding.FragmentCountryFlagBinding


class CountryFlag : Fragment() {
  private var binding:FragmentCountryFlagBinding?=null
  private val sharedViewModel:FlagViewModel by activityViewModels()
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentCountryFlagBinding.inflate(inflater,container,false)
    binding?.lifecycleOwner = this
    binding?.photosGrid?.adapter = PhotoGridAdapter()
    binding?.viweModel = sharedViewModel
    return binding?.root
  }



  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
}