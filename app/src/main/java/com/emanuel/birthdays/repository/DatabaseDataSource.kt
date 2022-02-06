package com.emanuel.birthdays.repository

import com.emanuel.birthdays.data.db.dao.FriendDao
import com.emanuel.birthdays.data.db.entity.FriendEntity

class DatabaseDataSource(
    private val friendDao: FriendDao
) : FriendRepository {

    override suspend fun insertFriend(name: String, date: String): Long {
        val friend = FriendEntity(
            name = name,
            birthdayDate = date
        )

        return friendDao.insert(friend)
    }

    override suspend fun getAllFriendsByBirthday(date: String): List<FriendEntity> {

        return friendDao.getAllFriendsByBirthday(date = date)
    }

    override suspend fun getAllFriend(): List<FriendEntity> {

        return friendDao.getAllFriend()
    }
}