package com.felipebertelli.convidados.repository

import android.content.Context
import com.felipebertelli.convidados.model.GuestModel

class GuestRepository(context: Context) {

    private val guestDataBase = GuestDatabase.getDatabase(context).guestDAO()

    fun update(guest: GuestModel): Boolean {
        return guestDataBase.update(guest) > 0
    }

    fun delete(id: Int) {
        val guest = get(id)
        guestDataBase.delete(guest)
    }

    fun get(id: Int): GuestModel {
        return guestDataBase.get(id)
    }

    fun getAll(): List<GuestModel> {
        return guestDataBase.getAll()
    }

    fun getPresent(): List<GuestModel> {
        return guestDataBase.getPresent()
    }

    fun getAbsent(): List<GuestModel> {
        return guestDataBase.getAbsent()
    }
    fun save(guest: GuestModel): Boolean {
        return guestDataBase.save(guest) > 0
    }
}


