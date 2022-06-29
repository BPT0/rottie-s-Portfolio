package com.example.velog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.*
import androidx.room.Database
import androidx.room.OnConflictStrategy.REPLACE

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
    }
}

@Entity
class UserProfile(

    @PrimaryKey val id: Int,

    @ColumnInfo(name="last_name")
    val lastName: String,

    @ColumnInfo(name="first_name")
    val firstName: String

)

@Database(entities = [UserProfile::class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun userProfileDao(): UserProfileDao
}

@Dao
interface UserProfileDao{
    // CRUD -> 데이터 베이스 조작
    // Query -> 데이터 베이스 조회
    @Insert(onConflict = REPLACE)
    fun insert(userProfile: UserProfile)

    @Delete
    fun delete(userProfile: UserProfile)

    @Query("SELECT * FROM userprofile")
    fun getAll() : List<UserProfile>

}


