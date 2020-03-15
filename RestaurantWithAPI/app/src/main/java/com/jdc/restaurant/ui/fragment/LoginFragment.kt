package com.jdc.restaurant.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.jdc.restaurant.R
import com.jdc.restaurant.api.ClientContext
import com.jdc.restaurant.databinding.FragmentLoginBinding
import com.jdc.restaurant.ui.model.LoginViewModel
import kotlinx.android.synthetic.main.fragment_tables.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model by viewModels<LoginViewModel>()
        val binding = FragmentLoginBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.model = model
    }
}
