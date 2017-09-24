package zamgerapi

import zamgerapi.types.Class

class ClassApi(private val zctx : ZamgerContext) {
    init {

    }

    fun GetClassById(id : Int) : Class {
        TODO()
    }

    fun GetClassesForGroup(group : Int) : List<Class> {
        TODO()
    }

    fun GetAttendanceForStudent(clazz : Int, student : Int) {
        TODO()
    }

    // todo ostale
}