package com.example.todaylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

data class TodoItem(
    val id: Int,
    val title: String,
    val isCompleted: Boolean = false
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TodayListScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodayListPreview() {
    MaterialTheme {
        TodayListScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodayListScreen() {
    val today = LocalDate.now()
    val dateText = today.format(
        DateTimeFormatter.ofPattern("yyyy 年 M 月 d 日 (E)", Locale.TAIWAN)
    )

    var todos by remember {
        mutableStateOf(
            listOf(
                TodoItem(1, "丟垃圾"),
                TodoItem(2, "洗碗")
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("今日清單") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = dateText,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(todos, key = { it.id }) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = item.isCompleted,
                            onCheckedChange = { checked ->
                                todos = todos.map {
                                    if (it.id == item.id) it.copy(isCompleted = checked) else it
                                }
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = item.title,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}
