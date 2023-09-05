package uz.datatalim.anim2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.datatalim.anim2.mode.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: User)

    @Query("SELECT * FROM users")
    fun loadUsers(): List<User>

    @Query("SELECT * FROM users WHERE id=:id")
    fun getUserById(id: Int): User

    @Query("DELETE FROM users WHERE id=:id")
    fun deleteUserById(id: Int)

    @Delete
    fun deleteUser(user: User)
}