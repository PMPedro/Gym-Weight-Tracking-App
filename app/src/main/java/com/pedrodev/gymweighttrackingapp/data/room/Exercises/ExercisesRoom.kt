    package com.example.gymweighttrackingapp.data.room.Exercises

    import androidx.room.ColumnInfo
    import androidx.room.Entity
    import androidx.room.PrimaryKey

    @Entity(tableName = "exercises-table")
    data class ExercisesRoom(
        @PrimaryKey(autoGenerate = true)
        val id : Long = 0L ,
        @ColumnInfo(name = "exercises-name")
        val name: String = "" ,
        @ColumnInfo(name = "exercises-type")
        val type: String = "" ,
        @ColumnInfo(name = "exercises-muscle")
        val muscle: String = "",
        @ColumnInfo(name = "exercises-difficulty")
        val difficulty: String = "",
        @ColumnInfo(name = "exercises-instructions")
        val instructions: String = "",
        @ColumnInfo(name = "exercises-equipments")
        val equipments: String ,
        @ColumnInfo(name = "exercises-sets")
        val sets : Int = 4,
        @ColumnInfo(name = "exercises-reps")
        val reps: Int = 12 ,
        @ColumnInfo(name = "exercises-weight")
        val weight: Float = 0f
    )




