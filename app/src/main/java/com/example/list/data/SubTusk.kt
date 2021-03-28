package com.example.list.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity( tableName = "sub_tusk",
    foreignKeys = [ForeignKey(
        entity = Task::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("task_id"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class SubTusk(@PrimaryKey(autoGenerate = true) var id:Int,
                   @ColumnInfo(name = "sub_title") var subTitle: String,
                   @ColumnInfo(name = "task_id") var id_task: Int)