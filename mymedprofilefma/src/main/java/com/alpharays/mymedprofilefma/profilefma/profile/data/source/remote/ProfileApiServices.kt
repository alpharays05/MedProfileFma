package com.alpharays.mymedprofilefma.profilefma.profile.data.source.remote

import com.alpharays.mymedprofilefma.profilefma.profile.data.di.profile_response_dto.ProfileResponseDto
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfileData
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.DOC_ID_KEYWORD
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.GET_CURRENT_PROFILE_DATA
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.GET_DOC_PROFILE_DATA
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.TOKEN_KEYWORD
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.UPDATE_PROFILE
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PUT

interface ProfileApiServices {
    @GET(GET_CURRENT_PROFILE_DATA)
    suspend fun fetchCurrentUserProfileData(
        @Header(TOKEN_KEYWORD) token: String,
    ): Response<ProfileResponseDto>

    @GET(GET_DOC_PROFILE_DATA)
    suspend fun fetchOtherUserProfileData(
        @Header(TOKEN_KEYWORD) token: String,
        @Header(DOC_ID_KEYWORD) docId: String?,
    ): Response<ProfileResponseDto>

    @PUT(UPDATE_PROFILE)
    suspend fun updateProfileInfo(
        @Body updateProfileInfo: ProfileData,
        @Header(TOKEN_KEYWORD) token: String,
    ): Response<ProfileData>
}