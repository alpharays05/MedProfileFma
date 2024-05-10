package com.alpharays.mymedprofilefma.profilefma.profile.data.di.profile_response_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserPost(
    @SerialName("comments")
    val comments: List<String?>? = listOf(),
    @SerialName("_id")
    val id: String? = null,
    @SerialName("postContent")
    val postContent: String? = null,
    @SerialName("postTitle")
    val postTitle: String? = null,
    @SerialName("posterId")
    val posterId: String? = null,
    @SerialName("posterName")
    val posterName: String? = null,
    @SerialName("reactions")
    val reactions: Reactions? = Reactions(),
    @SerialName("__v")
    val v: Int? = 0,
)