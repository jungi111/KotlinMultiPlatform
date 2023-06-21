package com.example.firstmultiplatform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Login View") },
                    modifier = Modifier.fillMaxWidth()
                )
            },
            content = {
                TabScreen()
            }
        )
    }
}

@Composable
fun TabScreen() {
    var tabState by remember { mutableStateOf(0) }
    val tabItem = listOf("tab1", "tab2")

    Column {
        TabRow(
            selectedTabIndex = tabState,
        ) {
            tabItem.forEachIndexed { index, item ->
                Tab(
                    selected = tabState == index,
                    onClick = { tabState = index }
                ) {
                    Column(
                        Modifier.padding(10.dp).height(100.dp).fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            Modifier.size(10.dp)
                                .align(Alignment.CenterHorizontally)
                                .background(
                                    color = if ((index == tabState)) MaterialTheme.colorScheme.primary
                                    else MaterialTheme.colorScheme.background
                                )
                        )
                        Text(
                            text = item,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
        when (tabState) {
            0 -> Text(
                "Tab1",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )

            1 -> LoginScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.padding(10.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.padding(10.dp)
        )

        Button(
            onClick = { /* 로그인 버튼 클릭 시 동작 처리 */ },
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Login")
        }
    }
}