package com.alpharays.mymedprofilefma.profilefma.profile.presentation.profile_screen.profile_ui_elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alpharays.mymedprofilefma.profilefma.profile.data.di.profile_response_dto.ProfileData
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.common.CustomScaffold
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.common.GlobalSearchBox
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.spacing

@Composable
fun MedicoProfile(navController: NavController) {
    val isTopBarPresent by remember { mutableStateOf(false) }
    val cardHeight = LocalConfiguration.current.screenHeightDp * 0.1f
    val data = ProfileData(
        name = "Shivang Gautam",
        about = "Had been in AIMS for last 10 years",
        department = "Surgeon"
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground),
    ) {
        CustomScaffold(
            isTopBarPresent = isTopBarPresent,
            navController = navController,
            topBarContent = {
                GlobalSearchBox(navController)
            }
        ) { innerPadding ->
            Column {
                Box {
                    ProfileHeader(navController)
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomCenter),
                    ) {
                        Spacer(
                            modifier = Modifier
                                .padding(
                                    top = cardHeight.dp
                                )
                        )
                        ProfileUserCard(profileData = data)
                    }
                }
                ProfileActivity()
            }
        }
    }
}

@Preview
@Composable
private fun MedicoProfilePreview() {
    val navController = rememberNavController()
    MedicoProfile(navController)
}