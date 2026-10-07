package com.example.gymweighttrackingapp.data.room

import android.content.Context
import androidx.room.Room
import com.example.gymweighttrackingapp.data.room.Exercises.ExerciseDAO
import com.example.gymweighttrackingapp.data.room.WorkoutExercise.WorkoutExerciseDao
import com.example.gymweighttrackingapp.data.room.WorkoutPlay.WorkoutPlayDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "gym_db"
        ).build()
    }

    @Provides
    fun provideWorkoutDao(db: AppDatabase): WorkoutPlayDAO {
        return db.workoutDAO()
    }

    @Provides
    fun provideWorkoutExerciseDao(db: AppDatabase): WorkoutExerciseDao {
        return db.workoutExerciseDAO()
    }

    @Provides
    fun provideExerciseDao(db: AppDatabase): ExerciseDAO {
        return db.exerciseDAO()
    }
}