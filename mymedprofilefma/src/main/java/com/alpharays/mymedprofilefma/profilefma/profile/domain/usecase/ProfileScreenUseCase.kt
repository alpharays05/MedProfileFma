package com.alpharays.mymedprofilefma.profilefma.profile.domain.usecase

import com.alpharays.alaskagemsdk.network.ResponseResult
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfileData
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfileResponse
import com.alpharays.mymedprofilefma.profilefma.profile.domain.repository.ProfileRepository
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.SOMETHING_WENT_WRONG
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
) {
    // getCurrentProfile
    operator fun invoke(token: String): Flow<ResponseResult<ProfileResponse>> = flow {
        emit(ResponseResult.Loading())
        try {
            val myProfileInfo = profileRepository.fetchCurrentUserProfileData(token)
            emit(myProfileInfo)
        } catch (e: Exception) {
            emit(ResponseResult.Error(SOMETHING_WENT_WRONG))
        }
    }

    // getDocProfile
    operator fun invoke(token: String, docId: String?): Flow<ResponseResult<ProfileResponse>> = flow {
        emit(ResponseResult.Loading())
        try {
            val docProfileInfo = profileRepository.fetchOtherUserProfileData(token, docId)
            emit(docProfileInfo)
        } catch (e: Exception) {
            emit(ResponseResult.Error(SOMETHING_WENT_WRONG))
        }
    }

    // updateProfile
    operator fun invoke(profileInfo: ProfileData, token: String): Flow<ResponseResult<ProfileData>> = flow {
        emit(ResponseResult.Loading())
        try {
            val updatedProfileInfo = profileRepository.updateProfileInfo(profileInfo, token)
            emit(updatedProfileInfo)
        } catch (e: Exception) {
            emit(ResponseResult.Error(SOMETHING_WENT_WRONG))
        }
    }
}