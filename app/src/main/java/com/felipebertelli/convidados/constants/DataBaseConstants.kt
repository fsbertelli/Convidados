package com.felipebertelli.convidados.constants

class DataBaseConstants private constructor(){
    object GUEST{
        const val TABLE_NAME = "Guest"
        const val ID = "guestid"

        object COLUMNS{
            const val ID = "ID"
            const val NAME = "Name"
            const val PRESENCE = "Presence"
        }

    }
}