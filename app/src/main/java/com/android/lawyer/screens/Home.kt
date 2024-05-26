package com.android.lawyer.screens

import com.android.lawyer.R
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.lawyer.model.LawSuits
import com.android.lawyer.model.MostAskedQuestion
import kotlinx.coroutines.launch

@Composable
fun Home(navController: NavHostController) {

    val lawReferences = listOf(
        LawSuits(painterResource(id = R.drawable.legal_2863339), "Law And Orders"),
        LawSuits(painterResource(id = R.drawable.verdict_4266423), "Divorce"),
        LawSuits(painterResource(id = R.drawable.policies_12183265), "Equality"),

        )

    val mostAskedQues = listOf(
        MostAskedQuestion(
            painterResource(id = R.drawable.woman_15998786),
            "Child Marriage",
            "child marriage is.."
        ),
        MostAskedQuestion(painterResource(id = R.drawable.judicial_10164980), "DPSP", "about dpsp"),
        MostAskedQuestion(
            painterResource(id = R.drawable.justice_10830899),
            "Equality",
            "about equality"
        ),


        )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = "Hello ujjwal", style = TextStyle(fontSize = 12.sp, color = Color.Black))

            IconButton(onClick = { /*TODO*/ }) {

                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = null)

            }
        }
        mainText(text = "this is my message")

        lawRecycler(lawSuits = lawReferences)

        mostAskedQuestion(mostAskedQues = mostAskedQues)

        myBottomSheet()

    }

}


@Composable
fun lawRecycler(lawSuits: List<LawSuits>) {
    val shape: Shape = RoundedCornerShape(8.dp)

    LazyRow(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(lawSuits) { item ->
            Card(
                modifier = Modifier
                    .padding(end = 3.dp)
                    .height(90.dp)
                    .width(90.dp)
                    .border(1.dp, Color.Gray, shape)
                    .clip(shape),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(14.dp),
                shape = shape
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Image(
                            painter = item.image,
                            contentDescription = null,
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape),
                            alignment = Alignment.Center
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = item.laws,
                            color = Color.Black,
                            fontSize = 14.sp,
                            maxLines = 4,
                            overflow = TextOverflow.Ellipsis

                        )
                    }
                }
            }
        }
    }
}


@Composable
fun mostAskedQuestion(mostAskedQues: List<MostAskedQuestion>) {
    val shape: Shape = RoundedCornerShape(8.dp)

    LazyRow(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(mostAskedQues) { item ->
            Card(
                modifier = Modifier
                    .padding(end = 3.dp)
                    .height(80.dp)
                    .width(150.dp)
                    .border(1.dp, Color.Gray, shape)
                    .clip(shape),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(14.dp),
                shape = shape
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Image(
                            painter = item.imageRef,
                            contentDescription = null,
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape),
                            alignment = Alignment.Center
                        )
                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Text(
                                text = item.heading,
                                color = Color.Black,
                                fontSize = 18.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            Text(
                                text = item.theory,
                                color = Color.Black,
                                fontSize = 12.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun myBottomSheet() {

    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded })
    val coroutineScope = rememberCoroutineScope()

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState, sheetContent = { BottomSheet() }, modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to bottom sheet playground!",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(color = Color.Blue),
                textAlign = TextAlign.Center,

                )
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {
                coroutineScope.launch {
                    if (sheetState.isVisible) sheetState.hide()
                    else sheetState.show()
                }
            }) {
                Text(text = "Click to show bottom sheet")
            }
        }
    }

}


@Composable
fun mainText(text: String) {

    Text(
        text = "Take control of your learning",
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        style = TextStyle(
            fontSize = 24.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
        )
    )
}


@Preview
@Composable
fun previewlaw() {
    val mostAskedQues = listOf(
        MostAskedQuestion(painterResource(id = R.drawable.image1), "Law Ref 1", "text"),
        MostAskedQuestion(painterResource(id = R.drawable.image1), "Law Ref 1", "text"),
        MostAskedQuestion(painterResource(id = R.drawable.image1), "Law Ref 1", "text"),


        )
    mostAskedQuestion(mostAskedQues = mostAskedQues)
}