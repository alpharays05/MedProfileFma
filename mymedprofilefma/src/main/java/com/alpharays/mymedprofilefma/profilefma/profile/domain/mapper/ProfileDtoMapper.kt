package com.alpharays.mymedprofilefma.profilefma.profile.domain.mapper

import com.alpharays.mymedprofilefma.profilefma.profile.data.di.profile_response_dto.ProfileResponseDto
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfileData
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfilePost
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfilePosts
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ProfileResponse
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.ReactionDetails
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.Reactions

fun ProfileResponseDto.toProfileResponseMapper(): ProfileResponse? {
    val profile = this.profileData
    val posts = profile?.posts ?: emptyList()
    return try {
        ProfileResponse(
            profileData = ProfileData(
                about = profile?.about,
                age = profile?.age,
                avatarImageUrl = profile?.avatarImageUrl,
                department = profile?.department,
                email = profile?.email,
                gender = profile?.gender,
                name = profile?.name,
                phone = profile?.phone,
                qualifications = profile?.qualifications,
                yearsOfExp = profile?.yearsOfExp,
            ),
            profilePosts = ProfilePosts(
                allPosts = posts.map {
                    ProfilePost(
                        comments = it?.comments,
                        postContent = it?.postContent,
                        postTitle = it?.postTitle,
                        posterId = it?.posterId,
                        posterName = it?.posterName,
                        reactions = Reactions(
                            angry = it?.reactions?.angry?.map { reaction ->
                                ReactionDetails(
                                    name = reaction?.name,
                                    reaction = reaction?.reaction,
                                )
                            },
                            support = it?.reactions?.support?.map { reaction ->
                                ReactionDetails(
                                    name = reaction?.name,
                                    reaction = reaction?.reaction,
                                )
                            },
                            celebrate = it?.reactions?.celebrate?.map { reaction ->
                                ReactionDetails(
                                    name = reaction?.name,
                                    reaction = reaction?.reaction,
                                )
                            },
                            like = it?.reactions?.like?.map { reaction ->
                                ReactionDetails(
                                    name = reaction?.name,
                                    reaction = reaction?.reaction,
                                )
                            },
                            love = it?.reactions?.love?.map { reaction ->
                                ReactionDetails(
                                    name = reaction?.name,
                                    reaction = reaction?.reaction,
                                )
                            },
                            insightful = it?.reactions?.insightful?.map { reaction ->
                                ReactionDetails(
                                    name = reaction?.name,
                                    reaction = reaction?.reaction,
                                )
                            },
                        )
                    )
                }
            )
        )
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}