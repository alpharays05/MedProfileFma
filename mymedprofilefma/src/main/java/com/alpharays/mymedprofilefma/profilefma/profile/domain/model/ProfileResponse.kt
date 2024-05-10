package com.alpharays.mymedprofilefma.profilefma.profile.domain.model

data class ProfileResponse(
    val profileData: ProfileData? = ProfileData(),
    val profilePosts: ProfilePosts? = ProfilePosts(),
)