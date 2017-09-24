package zamgerapi

import zamgerapi.types.Course

public class CourseAPI(private val zctx : ZamgerContext) {
    init {

    }

    // ay - -1 for current academic year
    public fun GetCourseById(id : Int, ay : Int = -1) : Course {
        TODO()
    }

    public fun GetProgrammeForSemester(programme : Int, sem : Int) : List<Course> {
        TODO()
    }

    public fun GetCoursesByTeacher(teacher : Int) : List<Course> {
        TODO()
    }

    public fun GetCoursesForStudent(student : Int) : List<Course> {
        TODO()
    }


}