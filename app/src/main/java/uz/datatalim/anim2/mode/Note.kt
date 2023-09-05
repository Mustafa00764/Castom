package uz.datatalim.anim2.mode

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val time: CharSequence,
    val text: CharSequence
)
