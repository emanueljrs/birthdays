package com.emanuel.birthdays.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.emanuel.birthdays.data.db.dao.FriendDao
import com.emanuel.birthdays.data.db.entity.FriendEntity

@Database(entities = [FriendEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val friendDao: FriendDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        //Garante que terá apenas uma instância
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance: AppDatabase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "app_database"
                    ).build()
                }
                return instance
            }
        }
    }
}