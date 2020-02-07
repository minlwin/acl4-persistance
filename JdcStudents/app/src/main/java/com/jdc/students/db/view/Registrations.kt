package com.jdc.students.db.view

import androidx.room.DatabaseView
import com.jdc.students.db.entity.Registration
import com.jdc.students.db.entity.Student
import java.util.*

@DatabaseView("""
    select r.id id, r.studentId studentId, r.classId classId, r.registDate registDate, 
    s.name studentName, s.phone phone, s.email email,
    cl.startDate startDate, c.name course 
    from Registration r 
    join Student s on r.studentId = s.id 
    join ClassRoom cl on r.classId = cl.id
    join Course c on cl.courseId = c.id
""")
data class Registrations(
    var id:Long = 0,
    var studentId:Long = 0,
    var classId:Long = 0,
    var registDate:Date? = null,
    var studentName:String = "",
    var phone:String = "",
    var email:String = "",
    var startDate:Date? = null,
    var course:String = ""
) {
    val registration:Registration
        get() = Registration(id, classId, studentId, registDate)

    val student:Student
        get() = Student(studentId, studentName, phone, email)
}