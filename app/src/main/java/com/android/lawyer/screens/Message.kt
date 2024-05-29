package com.android.lawyer.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.lawyer.model.Notification

@Composable
fun Message(navController: NavHostController){

    val notifications = listOf(
        Notification( "This is a Heading","this is a long message","click here"),
        Notification( "This is a Heading","this is a long message","click here"),
        Notification( "This is a Heading","this is a long message","click here"),
        Notification( "This is a Heading","this is a long message","click here"),
    )
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(notifications) { notification ->
            MessageItem(
                heading = notification.heading,
                notification = notification.notification,
                update = notification.update
            )
        }
    }
}

@Composable
fun MessageItem(
    heading: String,
    notification: String,
    update: String
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)) {
        Column {
            Text(text = heading, style = TextStyle(fontSize = 24.sp, color = Color.Black))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = notification, style = TextStyle(fontSize = 16.sp, color = Color.DarkGray))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = update, style = TextStyle(fontSize = 14.sp, color = Color.Blue))
            Divider(thickness = 2.dp)
        }
    }
}
