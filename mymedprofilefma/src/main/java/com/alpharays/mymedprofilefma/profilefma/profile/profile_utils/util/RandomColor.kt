package com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util

import androidx.compose.ui.graphics.Color
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.AppBackground
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.BackRed
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Black
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.BluishGray
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.BottomSheetColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.BoxMaterialBlack
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.CardTopBarColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.DarkBackground
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.DarkBottomNavBackground
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.ErrorColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.FinishGreen
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.FocusedTextColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray100
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray200
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray25
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray300
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray400
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray50
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray500
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray600
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray700
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray75
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray800
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray900
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Gray950
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.InverseSurface
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.LabelColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.LessFocusedTextColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.LightBackground
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.LiveRed
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.MaterialBlack
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.MaterialWhite
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.OnPrimaryDark
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.OnPrimaryFixed
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.OnSurfaceDarkEmphasis
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.OnSurfaceHighEmphasis
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.OverlayCollapsedContainer
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.OverlayDividerColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Pink40
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Pink80
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary100
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary200
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary300
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary400
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary500
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary600
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary700
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Primary800
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Purple40
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Purple80
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.PurpleGrey40
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.PurpleGrey80
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Red
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.ScoreGold
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Secondary200
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Secondary300
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Secondary400
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Secondary500
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.Secondary600
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.TeamChartGreen
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.TeamChartPurple
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.TertiaryGray
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.TextColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.TransparentColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.VerticalDividerColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.White
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.WicketRed
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.onPrimaryContainer
import kotlin.random.Random

object AllColors {
    val colorsList = listOf(
        Purple80,
        PurpleGrey80,
        Pink80,
        Purple40,
        PurpleGrey40,
        Pink40,
        TextColor,
        LabelColor,
        OverlayCollapsedContainer,
        OverlayDividerColor,
        DarkBottomNavBackground,
        TransparentColor,
        OnSurfaceDarkEmphasis,
        Black,
        White,
        Red,
        Gray25,
        Gray50,
        Gray75,
        Gray100,
        Gray200,
        Gray300,
        Gray400,
        Gray500,
        Gray600,
        Gray700,
        Gray800,
        Gray900,
        Gray950,
        InverseSurface,
        DarkBackground,
        LightBackground,
        AppBackground,
        BackRed,
        BottomSheetColor,
        OnSurfaceHighEmphasis,
        MaterialWhite,
        MaterialBlack,
        BoxMaterialBlack,
        BluishGray,
        VerticalDividerColor,
        FocusedTextColor,
        LessFocusedTextColor,
        LiveRed,
        WicketRed,
        ScoreGold,
        FinishGreen,
        Primary100,
        Primary200,
        Primary300,
        Primary400,
        Primary500,
        Primary600,
        Primary700,
        Primary800,
        OnPrimaryFixed,
        OnPrimaryDark,
        onPrimaryContainer,
        TertiaryGray,
        CardTopBarColor,
        Secondary200,
        Secondary300,
        Secondary400,
        Secondary500,
        Secondary600,
        ErrorColor,
        TeamChartGreen,
        TeamChartPurple
    )
}

class RandomColor {
    companion object {
        fun getRandomColor(): Color {
            val randomIndex = Random.nextInt(AllColors.colorsList.size)
            return AllColors.colorsList[randomIndex]
        }
    }
}