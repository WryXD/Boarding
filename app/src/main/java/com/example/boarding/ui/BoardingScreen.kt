package com.example.boarding.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BoardingScreen(
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxSize()) {

        val pagerState = rememberPagerState(pageCount = { 3 })

        val pages = listOf(BoardingPage.First, BoardingPage.Second, BoardingPage.Third)

        Spacer(modifier.height(16.dp))

        HorizontalPager(
            state = pagerState,
            modifier = modifier.fillMaxWidth()
        ) {
            BoardingPage(page = pages[it])
        }
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }
    }
}


@Composable
fun BoardingPage(
    page: BoardingPage,
    modifier: Modifier = Modifier,
) {
    Column {
        Image(
            painter = painterResource(id = page.image),
            contentDescription = null,
            modifier = modifier.fillMaxWidth()
        )

        Text(
            text = page.title,
            modifier = modifier.align(Alignment.CenterHorizontally)

        )
        Text(
            text = page.description,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BoardingScreenPreview() {
    BoardingScreen()
}
