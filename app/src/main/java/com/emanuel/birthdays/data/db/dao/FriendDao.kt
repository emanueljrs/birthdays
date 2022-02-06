package com.emanuel.birthdays.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.emanuel.birthdays.data.db.entity.FriendEntity

@Dao
interface FriendDao {

    @Insert
    suspend fun insert(friend: FriendEntity): Long

    @Query("SELECT * FROM friends WHERE birthday_date = :date")
    suspend fun getAllFriendsByBirthday(date: String): List<FriendEntity>

    @Query("SELECT * FROM friends")
    suspend fun getAllFriend(): List<FriendEntity>
}