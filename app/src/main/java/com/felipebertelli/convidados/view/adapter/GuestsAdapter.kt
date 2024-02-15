package com.felipebertelli.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felipebertelli.convidados.databinding.RowGuestBinding
import com.felipebertelli.convidados.model.GuestModel
import com.felipebertelli.convidados.view.listener.OnGuestListener
import com.felipebertelli.convidados.view.viewholder.GuestViewHolder

class GuestsAdapter : RecyclerView.Adapter<GuestViewHolder>() {
    private var guestList: List<GuestModel> = listOf()
    private lateinit var listener: OnGuestListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(guestList[position])
    }

    override fun getItemCount(): Int {
        return guestList.count()
    }


    fun updateGuests(list: List<GuestModel>) {
        guestList = list
        notifyDataSetChanged()
    }

    fun attachListener(guestListener: OnGuestListener){
        listener = guestListener
    }
}