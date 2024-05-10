package com.alpharays.mymedprofilefma.profilefma.profile.presentation.profile_screen


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alpharays.alaskagemsdk.network.ResponseResult
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfileResponse
import com.alpharays.mymedprofilefma.profilefma.profile.domain.usecase.ProfileUseCase
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.connectivity.NetworkConnectivityObserver
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.MedicoUtils
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.DOC_ID_KEYWORD
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCase: ProfileUseCase,
    networkObserver: NetworkConnectivityObserver,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private var token = ""
    private val _currentProfile = MutableStateFlow(ProfileResponseState())
    val currentProfile = _currentProfile.asStateFlow()

    private val _currentNetworkStatus = MutableStateFlow(networkObserver.isNetworkAvailable())
    val currentNetworkStatus = _currentNetworkStatus.asStateFlow()

    init {
        token = MedicoUtils.getAuthToken()
        val docId = savedStateHandle.get<String>(DOC_ID_KEYWORD)
        if (!docId.isNullOrEmpty()) {
            // other profile is to be fetched
            fetchOtherUserProfileData(docId)
        } else {
            fetchCurrentUserProfileData()
        }
    }

    private fun fetchCurrentUserProfileData() {
        useCase(token)
            .onEach { result ->
                when (result) {
                    is ResponseResult.Loading -> {
                        val state = ProfileResponseState(
                            isLoading = true,
                            profileInfo = null,
                            error = null
                        )
                        _currentProfile.update { state }
                    }

                    is ResponseResult.Success -> {
                        val state = ProfileResponseState(
                            isLoading = false,
                            profileInfo = result.data,
                            error = null
                        )
                        _currentProfile.update { state }
                    }

                    is ResponseResult.Error -> {
                        val state = ProfileResponseState(
                            isLoading = false,
                            profileInfo = null,
                            error = result.message ?: result.errorBody
                        )
                        _currentProfile.update { state }
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun fetchOtherUserProfileData(docId: String) {
        useCase(token, docId)
            .onEach { result ->
                when (result) {
                    is ResponseResult.Loading -> {
                        val state = ProfileResponseState(
                            isLoading = true,
                            profileInfo = null,
                            error = null
                        )
                        _currentProfile.update { state }
                    }

                    is ResponseResult.Success -> {
                        val state = ProfileResponseState(
                            isLoading = false,
                            profileInfo = result.data,
                            error = null
                        )
                        _currentProfile.update { state }
                    }

                    is ResponseResult.Error -> {
                        val state = ProfileResponseState(
                            isLoading = false,
                            profileInfo = null,
                            error = result.message ?: result.errorBody
                        )
                        _currentProfile.update { state }
                    }
                }
            }
            .launchIn(viewModelScope)
    }
}

data class ProfileResponseState(
    var isLoading: Boolean? = false,
    var profileInfo: ProfileResponse? = ProfileResponse(),
    var error: String? = null,
)