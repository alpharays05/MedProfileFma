package com.alpharays.mymedprofilefma.profilefma.profile.presentation.profile_screen.profile_ui_elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary200
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary300
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary600
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.spacing

@Composable
fun ProfileHeader(navController: NavController) {
    val cardHeight = LocalConfiguration.current.screenHeightDp * 0.2f
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight.dp),
        shape = RoundedCornerShape(
            bottomStart = MaterialTheme.spacing.large,
            bottomEnd = MaterialTheme.spacing.large
        ),
        colors = CardDefaults.cardColors(
//            containerColor = Primary300
            containerColor = Primary200
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
//            Image(
//                modifier = Modifier
//                    .size(cardHeight.dp)
//                    .padding(
//                        bottom = MaterialTheme.spacing.extraSmall
//                    ),
//                painter = painterResource(id = R.drawable.doctor_card_placeholder),
//                contentDescription = "doctor background placeholder",
//                contentScale = ContentScale.Crop
//            )
        }
    }
}

@Preview
@Composable
private fun ProfileHeaderPreview() {
    val navController = rememberNavController()
    ProfileHeader(navController)
}