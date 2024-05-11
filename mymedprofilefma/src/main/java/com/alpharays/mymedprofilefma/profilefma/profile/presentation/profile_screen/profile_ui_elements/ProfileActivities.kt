package com.alpharays.mymedprofilefma.profilefma.profile.presentation.profile_screen.profile_ui_elements

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.SelectedTabColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.SelectedTabContentColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.UnSelectedTabColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.UnSelectedTabContentColor
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.fontSize
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.spacing
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileActivities() {
    val headersList = listOf(PagerHeader("Posts"), PagerHeader("Comments"))
    val pagerState = rememberPagerState(
        pageCount = { headersList.size },
        initialPage = 0
    )
    Column {
        PagerHeadersBar(
            headers = headersList,
            currentPage = pagerState.currentPage,
            pagerState = pagerState
        )
        HorizontalPager(
            state = pagerState,
            verticalAlignment = Alignment.Top,
            userScrollEnabled = false
        ) { page ->
            when (page) {
                0 -> {
                    DoctorAllPosts()
                }

                1 -> {
                    DoctorAllComments()
                }
            }
        }
    }
}

data class PagerHeader(
    val name: String,
)


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerHeadersBar(
    headers: List<PagerHeader>,
    currentPage: Int,
    pagerState: PagerState,
) {
    val scope = rememberCoroutineScope()
    var selectedIndex by remember { mutableIntStateOf(0) }
    val textColor = MaterialTheme.colorScheme.background
    val animatedColor by animateColorAsState(targetValue = textColor, label = "")
    val style = TextStyle(
        color = animatedColor,
        fontSize = MaterialTheme.typography.labelMedium.fontSize,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center
    )

    LazyRow(
        modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small)
    ) {
        itemsIndexed(headers) { index, header ->
            val isSelected = currentPage == index
            val text = header.name

            ElevatedButton(
                modifier = Modifier.padding(end = MaterialTheme.spacing.extraSmall),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) SelectedTabColor else UnSelectedTabColor,
                    contentColor = if (isSelected) SelectedTabContentColor else UnSelectedTabContentColor
                ),
                onClick = {
                    scope.launch {
                        selectedIndex = index
                        pagerState.animateScrollToPage(page = index)
                    }
                },
                shape = RoundedCornerShape(MaterialTheme.spacing.small)
            ) {
                Text(
                    text = text,
                    style = style
                )
            }
        }
    }
}

@Composable
fun DoctorAllPosts() {
    Column {
        Text(
            modifier = Modifier
                .padding(MaterialTheme.spacing.small)
                .padding(bottom = MaterialTheme.spacing.small),
            text = "Post 1",
            style = TextStyle(
                fontSize = MaterialTheme.fontSize.medSmall,
                fontWeight = FontWeight.Bold
            )
        )
        Row(
            modifier = Modifier
                .clickable { },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Show all posts"
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowRightAlt,
                contentDescription = "show all posts"
            )
        }
    }
}

@Composable
fun DoctorAllComments() {

}