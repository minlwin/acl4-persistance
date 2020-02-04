package com.jdc.students.db.view

import androidx.room.DatabaseView
import java.util.*

@DatabaseView("""
    select r.id id, s.name student, s.phone phone, r.registDate registDate, 
    c.name course, cl.startDate startDate 
    from Registration r 
    join Student s on r.studentId = s.id 
    join ClassRoom cl on r.classId = cl.id
    join Course c on cl.courseId = c.id
""")
data class Registrations(
    val id:Long,
    val student:String,
    val phone:String,
    val registDate:Date?,
    val course:String,
    val startDate:Date?
)