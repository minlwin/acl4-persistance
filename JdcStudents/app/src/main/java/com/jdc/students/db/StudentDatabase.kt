package com.jdc.students.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jdc.students.db.converter.DateConverter
import com.jdc.students.db.dao.ClassRoomDao
import com.jdc.students.db.dao.CourseDao
import com.jdc.students.db.dao.RegistrationDao
import com.jdc.students.db.dao.StudentDao
import com.jdc.students.db.entity.ClassRoom
import com.jdc.students.db.entity.Course
import com.jdc.students.db.entity.Registration
import com.jdc.students.db.entity.Student
import com.jdc.students.db.view.Registrations

@Database(
    entities = [
        Course::class,
        ClassRoom::class,
        Student::class,
        Registration::class
    ],
    views = [
        Registrations::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [
    DateConverter::class
])
abstract class StudentDatabase : RoomDatabase() {

    abstract fun courseDao(): CourseDao
    abstract fun classRoomDao(): ClassRoomDao
    abstract fun studentDao(): StudentDao
    abstract fun registrationDao(): RegistrationDao

    companion object {
        private lateinit var db: StudentDatabase

        fun database(context: Context) = if (::db.isInitialized) db else
            Room.databaseBuilder(
                context,
                StudentDatabase::class.java,
                "com.jdc.student.db.StudentDB"
            )
                .build()
                .also {
                    db = it
                }
    }
}