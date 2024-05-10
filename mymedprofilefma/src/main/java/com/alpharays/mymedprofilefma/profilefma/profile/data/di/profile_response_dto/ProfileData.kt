package com.alpharays.mymedprofilefma.profilefma.profile.data.di.profile_response_dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileData(
    @SerialName("about")
    val about: String? = null,
    @SerialName("age")
    val age: String? = null,
    @SerialName("avatarImageUrl")
    val avatarImageUrl: String? = null,
    @SerialName("department")
    val department: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("gender")
    val gender: String? = null,
    @SerialName("_id")
    val id: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("phone")
    val phone: String? = null,
    @SerialName("posts")
    val posts: List<UserPost?>? = listOf(),
    @SerialName("qualifications")
    val qualifications: String? = null,
    @SerialName("__v")
    val v: Int? = 0,
    @SerialName("yearsOfExp")
    val yearsOfExp: String? = null,
)