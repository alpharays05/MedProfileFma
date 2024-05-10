package com.alpharays.mymedprofilefma.profilefma.profile.domain.model

data class ProfilePost(
    val comments: List<String?>? = listOf(),
    val postContent: String? = null,
    val postTitle: String? = null,
    val posterId: String? = null,
    val posterName: String? = null,
    val reactions: Reactions? = Reactions(),
)