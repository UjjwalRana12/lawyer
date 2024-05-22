package com.android.lawyer.screens

import com.android.lawyer.R
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Start
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable
fun Home(navController: NavHostController) {

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
        myBottomSheet()

    }

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun myBottomSheet() {

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
    )
    val coroutineScope = rememberCoroutineScope()

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = { BottomSheet() },
        modifier = Modifier.fillMaxSize()
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
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    coroutineScope.launch {
                        if (sheetState.isVisible) sheetState.hide()
                        else sheetState.show()
                    }
                }
            ) {
                Text(text = "Click to show bottom sheet")
            }
        }
    }

}

@Composable
fun BottomSheet() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.padding(32.dp).verticalScroll(scrollState)
    ) {
        Text(
            text = "Bottom sheet",
            style = TextStyle(color = Color.Blue)

        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Click outside the bottom sheet to hide it",
            style = TextStyle(color = Color.Blue)
        )
        Text(
            text = "Bottom sheet",
            style = TextStyle(color = Color.Blue)

        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Click outside the bottom sheet to hide it",
            style = TextStyle(color = Color.Blue)
        )
        Text(
            text = "Bottom sheet",
            style = TextStyle(color = Color.Blue)

        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Click outside the bottom sheet to hide it",
            style = TextStyle(color = Color.Blue)
        )
        Text(
            text = "Bottom sheet",
            style = TextStyle(color = Color.Blue)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Click outside the bottom sheet to hide it",
            style = TextStyle(color = Color.Blue)
        )
        Text(
            text = "Bottom sheet",
            style = TextStyle(color = Color.Blue)

        )

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Click outside the bottom sheet to hide it",
            style = TextStyle(color = Color.Blue)
        )
        Text(
            text = "Bottom sheet",
            style = TextStyle(color = Color.Blue)

        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Click outside the bottom sheet to hide it",
            style = TextStyle(color = Color.Blue)
        )
         Text(
            text = "Bottom sheet",
            style = TextStyle(color = Color.Blue)

        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Click outside the bottom sheet to hide it",
            style = TextStyle(color = Color.Blue)
        )
         Text(
            text = "Bottom sheet",
            style = TextStyle(color = Color.Blue)

        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Click outside the bottom sheet to hide it",
            style = TextStyle(color = Color.Blue)
        )
         Text(
            text = "Bottom sheet",
            style = TextStyle(color = Color.Blue)

        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Click outside the bottom sheet to hide it",
            style = TextStyle(color = Color.Blue)
        )
         Text(
            text = "Bottom sheet",
            style = TextStyle(color = Color.Blue)

        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Click outside the bottom sheet to hide it",
            style = TextStyle(color = Color.Blue)
        )

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
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
    )


}

@Preview
@Composable
fun previewBottom() {
    //myBottomSheet()
    val nav = rememberNavController()
    Home(navController = nav)
// BottomSheet()
}