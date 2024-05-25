package com.android.lawyer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.lawyer.R
import com.android.lawyer.model.LawyerDisplayItem




@Composable
fun BottomSheet() {
    val scrollState = rememberScrollState()
    val LawyerDisplayItems = listOf(
        LawyerDisplayItem(painterResource(R.drawable.image1), "This is a long text that should be ellipsized after a certain number of words."),
        LawyerDisplayItem(painterResource(R.drawable.image2), "Another example text to show ellipsization."),
        LawyerDisplayItem(painterResource(R.drawable.image3), "Short text."),
        LawyerDisplayItem(painterResource(R.drawable.image3), "Short text."),
        LawyerDisplayItem(painterResource(R.drawable.image3), "Short text.")
    )
    Column(
        modifier = Modifier
            .padding(32.dp)
            .verticalScroll(scrollState)
            .fillMaxSize()
    ) {
        displayLawyer(LawyerDisplayItems = LawyerDisplayItems)
    }
}


@Composable
fun displayLawyer(LawyerDisplayItems: List<LawyerDisplayItem>, wordLimit: Int = 10) {


    LazyRow(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(LawyerDisplayItems) { item ->
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {

                Image(
                    painter = item.image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .padding(end = 8.dp),
                    contentScale = ContentScale.Crop
                )

                Text(text = item.name.truncateToWords(wordLimit), maxLines = 1, overflow = TextOverflow.Ellipsis, modifier = Modifier.size(100.dp))
            }

        }

    }
}

fun String.truncateToWords(wordLimit: Int): String {
    val words = this.split(" ")
    return if (words.size <= wordLimit) {
        this
    } else {
        words.take(wordLimit).joinToString(" ") + "..."
    }
}





@Preview
@Composable
fun previewBottom() {


    val LawyerDisplayItems = listOf(
        LawyerDisplayItem(painterResource(R.drawable.image1), "This is a long text that should be ellipsized after a certain number of words."),
        LawyerDisplayItem(painterResource(R.drawable.image2), "Another example text to show ellipsization."),
        LawyerDisplayItem(painterResource(R.drawable.image3), "Short text."),
        LawyerDisplayItem(painterResource(R.drawable.image3), "Short text."),
        LawyerDisplayItem(painterResource(R.drawable.image3), "Short text.")
    )
    displayLawyer(LawyerDisplayItems = LawyerDisplayItems)

}