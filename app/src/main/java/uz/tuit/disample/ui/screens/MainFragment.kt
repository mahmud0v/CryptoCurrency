package uz.tuit.disample.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uz.tuit.disample.adapter.CryptoAdapter
import uz.tuit.disample.databinding.MainFragmentBinding
import uz.tuit.disample.model.CryptoCurrency
import uz.tuit.disample.ui.viewmodels.MainViewModel
import java.util.*

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: CryptoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = CryptoAdapter()
        viewModel.cryptoCurrency.observe(viewLifecycleOwner, observer)
        binding.rvView.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(requireContext())
        }


    }

    private val observer = Observer<List<CryptoCurrency>> {
        adapter.differ.submitList(it)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}