package com.example.shaditask.data.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ApiResponse(
    @SerializedName("results")
    @Expose
    val results: ArrayList<Result?>?,
    @SerializedName("info")
    @Expose
    val info: Info?
) {
    data class Result(
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
        @SerializedName("login")
        @Expose
        val login: Login?,
        @SerializedName("dob")
        @Expose
        val dob: Dob?,
        @SerializedName("registered")
        @Expose
        val registered: Registered?,
        @SerializedName("phone")
        @Expose
        val phone: String?,
        @SerializedName("cell")
        @Expose
        val cell: String?,
        @SerializedName("id")
        @Expose
        val id: Id?,
        @SerializedName("picture")
        @Expose
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
            @SerializedName("street")
            @Expose
            val street: Street?,
            @SerializedName("city")
            @Expose
            val city: String?,
            @SerializedName("state")
            @Expose
            val state: String?,
            @SerializedName("country")
            @Expose
            val country: String?,
            @SerializedName("postcode")
            @Expose
            val postcode: String?,
            @SerializedName("coordinates")
            @Expose
            val coordinates: Coordinates?,
            @SerializedName("timezone")
            @Expose
            val timezone: Timezone?
        ) {
            data class Street(
                @SerializedName("number")
                @Expose
                val number: String?,
                @SerializedName("name")
                @Expose
                val name: String?
            )

            data class Coordinates(
                @SerializedName("latitude")
                @Expose
                val latitude: String?,
                @SerializedName("longitude")
                @Expose
                val longitude: String?
            )

            data class Timezone(
                @SerializedName("offset")
                @Expose
                val offset: String?,
                @SerializedName("description")
                @Expose
                val description: String?
            )
        }

        data class Login(
            @SerializedName("uuid")
            @Expose
            val uuid: String?,
            @SerializedName("username")
            @Expose
            val username: String?,
            @SerializedName("password")
            @Expose
            val password: String?,
            @SerializedName("salt")
            @Expose
            val salt: String?,
            @SerializedName("md5")
            @Expose
            val md5: String?,
            @SerializedName("sha1")
            @Expose
            val sha1: String?,
            @SerializedName("sha256")
            @Expose
            val sha256: String?
        )

        data class Dob(
            @SerializedName("date")
            @Expose
            val date: String?,
            @SerializedName("age")
            @Expose
            val age: String?
        )

        data class Registered(
            @SerializedName("date")
            @Expose
            val date: String?,
            @SerializedName("age")
            @Expose
            val age: Int?
        )

        data class Id(
            @SerializedName("name")
            @Expose
            val name: String?,
            @SerializedName("value")
            @Expose
            val value: String?
        )

        data class Picture(
            @SerializedName("large")
            @Expose
            val large: String?,
            @SerializedName("medium")
            @Expose
            val medium: String?,
            @SerializedName("thumbnail")
            @Expose
            val thumbnail: String?
        )
    }

    data class Info(
        @SerializedName("seed")
        @Expose
        val seed: String?,
        @SerializedName("results")
        @Expose
        val results: String?,
        @SerializedName("page")
        @Expose
        val page: String?,
        @SerializedName("version")
        @Expose
        val version: String?
    )
}