package com.alpharays.mymedprofilefma.profilefma.profile.domain.repository

import com.alpharays.alaskagemsdk.network.ResponseResult
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfileData
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfileResponse

interface ProfileRepository {
    suspend fun fetchOtherUserProfileData(token: String, docId: String?): ResponseResult<ProfileResponse>
    suspend fun fetchCurrentUserProfileData(token: String): ResponseResult<ProfileResponse>
    suspend fun updateProfileInfo(profileInfo: ProfileData, token: String): ResponseResult<ProfileData>
}