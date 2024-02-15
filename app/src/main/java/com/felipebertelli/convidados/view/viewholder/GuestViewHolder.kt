package com.felipebertelli.convidados.view.viewholder

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.felipebertelli.convidados.databinding.RowGuestBinding
import com.felipebertelli.convidados.model.GuestModel
import com.felipebertelli.convidados.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestBinding, private val listener: OnGuestListener) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name

        bind.textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        bind.textName.setOnLongClickListener(View.OnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de convidado")
                .setMessage("Tem certeza que deseja remover?")
                .setPositiveButton("Sim") { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNegativeButton("Não", null)
                .create()
                .show()

            true
        })
    }
}