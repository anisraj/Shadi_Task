package com.example.shaditask.data.model


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.shaditask.data.utils.VariableConstants
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ApiResponse(
    @SerializedName("results")
    @Expose
    val results: List<Result?>?
) {
    @Entity(tableName = VariableConstants.TABLE_NAME)
    data class Result(
        @PrimaryKey(autoGenerate = true)
        val profileId: Int? = null,
        var isAccepted: Boolean = false,
        var isRejected: Boolean = false,
        @SerializedName("gender")
        @Expose
        val gender: String?,
        @SerializedName("name")
        @Expose
        val name: Name?,
        @SerializedName("location")
        @Expose
        val location: Location?,
        @SerializedName("email")
        @Expose
        val email: String?,
        @SerializedName("dob")
        @Expose
        val dob: Dob?,
        @SerializedName("phone")
        @Expose
        val phone: String?,
        @SerializedName("cell")
        @Expose
        val cell: String?,
        @SerializedName("picture")
        @Expose
        @Embedded
        val picture: Picture?,
        @SerializedName("nat")
        @Expose
        val nat: String?
    ) {
        data class Name(
            @SerializedName("title")
            @Expose
            val title: String?,
            @SerializedName("first")
            @Expose
            val first: String?,
            @SerializedName("last")
            @Expose
            val last: String?
        )

        data class Location(
            @SerializedName("city")
            @Expose
            val city: String?,
            @SerializedName("state")
            @Expose
            val state: String?
        )

        data class Dob(
            @SerializedName("age")
            @Expose
            val age: String?
        )

        data class Picture(
            @SerializedName("large")
            @Expose
            val large: String?
        )
    }
}