package com.alpharays.mymedprofilefma.profilefma.profile.data.di.profile_response_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReactionDetails(
    @SerialName("name")
    val name: String? = null,
    @SerialName("reaction")
    val reaction: String? = null,
    @SerialName("reactionId")
    val reactionId: String? = null,
)