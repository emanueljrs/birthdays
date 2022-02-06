package com.emanuel.birthdays.repository

import com.emanuel.birthdays.data.db.entity.FriendEntity

interface FriendRepository {

    suspend fun insertFriend(name: String, date: String): Long

    suspend fun getAllFriendsByBirthday(date: String): List<FriendEntity>

    suspend fun getAllFriend(): List<FriendEntity>
}