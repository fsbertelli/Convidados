package com.felipebertelli.convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.felipebertelli.convidados.constants.DataBaseConstants
import com.felipebertelli.convidados.databinding.FragmentAbsentBinding
import com.felipebertelli.convidados.view.adapter.GuestsAdapter
import com.felipebertelli.convidados.view.listener.OnGuestListener
import com.felipebertelli.convidados.viewmodel.GuestsViewModel

class AbsentFragment : Fragment() {

    private var _binding: FragmentAbsentBinding? = null
    private lateinit var viewModel: GuestsViewModel
    private val adapter = GuestsAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        viewModel = ViewModelProvider(this).get(GuestsViewModel::class.java)
        _binding = FragmentAbsentBinding.inflate(inflater, container, false)

        binding.recyclerAbsents.layoutManager = LinearLayoutManager(context)
        binding.recyclerAbsents.adapter = adapter

            val listener = object : OnGuestListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(DataBaseConstants.GUEST.ID, id)
                intent.putExtras(bundle)
                startActivity(Intent(intent))
            }

            override fun onDelete(id: Int) {
                viewModel.delete(id)
                viewModel.getAll()
            }
        }
        adapter.attachListener(listener)
        observe()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAbsent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.guestList.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)
        }
    }
}