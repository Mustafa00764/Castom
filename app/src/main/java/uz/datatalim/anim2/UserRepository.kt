package uz.datatalim.anim2

import android.app.Application
import uz.datatalim.anim2.mode.User


class UserRepository(private val application: Application) {
    private val userDao = AppDatabase.appDatabase(application).getUserDao()

    fun getAllUsers(): List<User> {
        return userDao.loadUsers()
    }

    fun getUserById(id: Int) = userDao.getUserById(id)


    fun saveUser(user: User) {
        userDao.saveUser(user)
    }

    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }


}