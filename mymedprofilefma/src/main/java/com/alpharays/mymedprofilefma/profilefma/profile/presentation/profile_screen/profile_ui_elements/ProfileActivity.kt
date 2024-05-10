package com.alpharays.mymedprofilefma.profilefma.profile.presentation.profile_screen.profile_ui_elements

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.fontSize
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.theme.spacing
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileActivity() {
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
            when(page) {
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
    val name: String
)


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerHeadersBar(
    headers: List<PagerHeader>,
    currentPage: Int,
    pagerState: PagerState
) {
    val scope = rememberCoroutineScope()
    var selectedIndex by remember { mutableIntStateOf(0) }

    TabRow(
        selectedTabIndex = currentPage,
        divider = {},
        containerColor = MaterialTheme.colorScheme.background
    ) {
        headers.forEachIndexed { index, header ->
            val isSelected = currentPage == index
            val text = header.name
            val textColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(0.8f)
            val animatedColor by animateColorAsState(targetValue = textColor, label = "")
            val style = TextStyle(
                color = animatedColor,
                fontSize = MaterialTheme.typography.labelMedium.fontSize,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )

            Tab(
                selected = isSelected,
                onClick = {
                    scope.launch {
                        selectedIndex = index
                        pagerState.animateScrollToPage(page = index)
                    }
                },
                text = { Text(text = text, style = style, modifier = Modifier.fillMaxWidth()) },
            )
        }
    }
}

@Composable
fun DoctorAllPosts() {
    Column {
        Text(
            modifier = Modifier.padding(MaterialTheme.spacing.small).padding(bottom = MaterialTheme.spacing.small),
            text = "Post 1",
            style = TextStyle(
                fontSize = MaterialTheme.fontSize.medSmall,
                fontWeight = FontWeight.Bold
            )
        )
        Row(
            modifier = Modifier
                .clickable {  },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Show all posts"
            )
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowRightAlt, contentDescription = "show all posts")
        }
    }
}

@Composable
fun DoctorAllComments() {

}