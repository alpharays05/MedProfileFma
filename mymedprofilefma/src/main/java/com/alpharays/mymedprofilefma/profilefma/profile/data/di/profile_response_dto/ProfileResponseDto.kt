package com.alpharays.mymedprofilefma.profilefma.profile.data.di.profile_response_dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponseDto(
    @SerialName("profileData")
    val profileData: ProfileData? = ProfileData(),
    @SerialName("error")
    val error: String? = null,
    @SerialName("errorlist")
    val errorlist: List<String?>? = listOf(),
    @SerialName("success")
    val success: Int? = 0,
)