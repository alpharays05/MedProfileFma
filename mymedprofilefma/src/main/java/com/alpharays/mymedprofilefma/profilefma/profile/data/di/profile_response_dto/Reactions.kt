package com.alpharays.mymedprofilefma.profilefma.profile.data.di.profile_response_dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Reactions(
    @SerialName("angry")
    val angry: List<ReactionDetails?>? = listOf(),
    @SerialName("celebrate")
    val celebrate: List<ReactionDetails?>? = listOf(),
    @SerialName("insightful")
    val insightful: List<ReactionDetails?>? = listOf(),
    @SerialName("like")
    val like: List<ReactionDetails?>? = listOf(),
    @SerialName("love")
    val love: List<ReactionDetails?>? = listOf(),
    @SerialName("support")
    val support: List<ReactionDetails?>? = listOf(),
)