package com.alpharays.mymedprofilefma.profilefma.profile.domain.model

data class Reactions(
    val angry: List<ReactionDetails?>? = listOf(),
    val support: List<ReactionDetails?>? = listOf(),
    val celebrate: List<ReactionDetails?>? = listOf(),
    val like: List<ReactionDetails?>? = listOf(),
    val love: List<ReactionDetails?>? = listOf(),
    val insightful: List<ReactionDetails?>? = listOf(),
)