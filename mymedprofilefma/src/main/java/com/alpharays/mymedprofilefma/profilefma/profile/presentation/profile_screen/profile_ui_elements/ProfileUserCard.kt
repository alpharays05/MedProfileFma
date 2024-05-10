package com.alpharays.mymedprofilefma.profilefma.profile.presentation.profile_screen.profile_ui_elements

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.alpharays.mymedprofilefma.R
import com.alpharays.mymedprofilefma.profilefma.profile.data.di.profile_response_dto.ProfileData
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.OnPrimaryFixed
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.OverlayDividerColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary200
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary500
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary800
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.TextColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.fontSize
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.size
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.spacing
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.RandomColor
import kotlin.random.Random

@Composable
fun ProfileUserCard(
    modifier: Modifier = Modifier,
    profileData: ProfileData = ProfileData(),
    onEditProfile: () -> Unit = {}
) {
    val style = TextStyle(
        fontSize = MaterialTheme.fontSize.medium,
        fontWeight = FontWeight.W600,
        color = TextColor,
        textAlign = TextAlign.Center
    )
    val style1 = TextStyle(
        fontSize = MaterialTheme.fontSize.medSmall,
        fontWeight = FontWeight.Normal,
        color = OverlayDividerColor
    )
    val style2 = TextStyle(
        fontSize = MaterialTheme.fontSize.medSmall2,
        fontWeight = FontWeight.W400,
        color = OnPrimaryFixed,
        textAlign = TextAlign.Center
    )

    Card(
        modifier = modifier.padding(MaterialTheme.spacing.small),
        elevation = CardDefaults.cardElevation(
            defaultElevation = MaterialTheme.spacing.extraSmall
        )
    ) {
        Column(
            modifier = Modifier.padding(MaterialTheme.spacing.medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = modifier
                    .padding(MaterialTheme.spacing.medium)
                    .clip(CircleShape),
                colors = CardDefaults.cardColors(
                    containerColor = Primary800
                )
            ) {
                Image(
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.small)
                        .size(MaterialTheme.size.doubleExtraLarge),
                    painter = painterResource(id = R.drawable.doctor_card_placeholder),
                    contentDescription = "doctor background placeholder",
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(
                        bottom = MaterialTheme.spacing.small
                    ),
                text = profileData.name ?: "--",
                style = style
            )

            Row(
                modifier = Modifier
                    .padding(bottom = MaterialTheme.spacing.medSmall)
                    .clickable { onEditProfile() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .padding(end = MaterialTheme.spacing.extraSmall)
                        .size(MaterialTheme.size.avgSmall),
                    imageVector = Icons.Default.Edit,
                    contentDescription = "edit profile"
                )

                Text(
                    text = "Edit profile",
                    style = style1
                )
            }

            Text(
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.extraSmall),
                text = profileData.department ?: "--",
                style = style2
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(bottom = MaterialTheme.spacing.medium),
                text = (profileData.about ?: "--"),
                style = style2
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(bottom = MaterialTheme.spacing.medium)
                    .fillMaxWidth(0.75f),
                color = Primary200.copy(alpha = 0.5f)
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(0.75f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                items(6) {
                    DoctorSpecialityBlocks(style2)
                }
            }
        }
    }
}

@Composable
fun DoctorSpecialityBlocks(style: TextStyle) {
    Column(
        modifier = Modifier
            .padding(MaterialTheme.spacing.extraSmall),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.Circle,
            contentDescription = "contentDescription",
            modifier = Modifier
                .size(MaterialTheme.size.defaultIconSize)
                .clip(CircleShape),
            tint = RandomColor.getRandomColor()
        )
        Text(
            text = "Surgeon",
            style = style
        )
    }
}

@Preview
@Composable
private fun ProfileUserCardPreview() {
    val navController = rememberNavController()
    val data = ProfileData(
        name = "Shivang Gautam",
        about = "Had been in AIMS for last 10 years",
        department = "Surgeon"
    )
    ProfileUserCard(Modifier, data)
}