package com.alpharays.mymedprofilefma.profilefma.profile.data.source.repo_impl

import com.alpharays.alaskagemsdk.network.ResponseHandler
import com.alpharays.alaskagemsdk.network.ResponseResult
import com.alpharays.mymedprofilefma.profilefma.profile.data.source.remote.ProfileApiServices
import com.alpharays.mymedprofilefma.profilefma.profile.domain.mapper.toProfileResponseMapper
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfileData
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfileResponse
import com.alpharays.mymedprofilefma.profilefma.profile.domain.repository.ProfileRepository
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.SOMETHING_WENT_WRONG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileApiServices: ProfileApiServices,
    private val responseHandler: ResponseHandler
) : ProfileRepository {
    override suspend fun fetchCurrentUserProfileData(token: String): ResponseResult<ProfileResponse> {
        return withContext(Dispatchers.IO) {
            try {
                responseHandler.callAPI {
                    withContext(Dispatchers.IO) {
                        val response = profileApiServices
                            .fetchCurrentUserProfileData(token)
                            .body()?.toProfileResponseMapper()
                        println("current_profile_response :1: ${response?.profileData}")
                        println("current_profile_response :2: ${response?.profilePosts}")
                        Response.success(response)
                    }
                }
            } catch (e: Exception) {
                ResponseResult.Error(SOMETHING_WENT_WRONG)
            }
        }
    }

    override suspend fun fetchOtherUserProfileData(token: String, docId: String?): ResponseResult<ProfileResponse> {
        return withContext(Dispatchers.IO) {
            try {
                responseHandler.callAPI {
                    withContext(Dispatchers.IO) {
                        val response = profileApiServices
                            .fetchOtherUserProfileData(token, docId)
                            .body()?.toProfileResponseMapper()
                        Response.success(response)
                    }
                }
            } catch (e: Exception) {
                ResponseResult.Error(SOMETHING_WENT_WRONG)
            }
        }
    }

    override suspend fun updateProfileInfo(
        profileInfo: ProfileData,
        token: String,
    ): ResponseResult<ProfileData> {
        return withContext(Dispatchers.IO) {
            try {
                responseHandler.callAPI {
                    withContext(Dispatchers.IO) {
                        profileApiServices.updateProfileInfo(profileInfo, token)
                    }
                }
            } catch (e: Exception) {
                ResponseResult.Error(SOMETHING_WENT_WRONG)
            }
        }
    }
}