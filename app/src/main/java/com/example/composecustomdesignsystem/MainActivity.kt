package com.example.composecustomdesignsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecustomdesignsystem.ui.theme.ComposeCustomDesignSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesignSystem()
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun DesignSystem() {
    var tabIndex by remember { mutableStateOf(0) }
    var darkEnabled by remember { mutableStateOf(false) }
    val tabTitles = listOf("Typography", "Button", "Controls", "Content")
    ComposeCustomDesignSystemTheme(darkTheme = darkEnabled) {
        Scaffold(
            topBar = {
                Column {
                    TopAppBar(
                        { Text("Custom Design System") },
                        actions = {
                            IconButton(onClick = { darkEnabled = !darkEnabled }) {
                                Icon(
                                    imageVector = Icons.Filled.ExitToApp,
                                    contentDescription = "",
                                )
                            }
                        }
                    )
                    ScrollableTabRow(
                        backgroundColor = MaterialTheme.colors.surface,
                        selectedTabIndex = tabIndex
                    ) {
                        tabTitles.forEachIndexed { index, title ->
                            Tab(selected = tabIndex == index,
                                onClick = { tabIndex = index },
                                text = { Text(text = title) })
                        }
                    }
                }
            },
            content = {
                when (tabIndex) {
                    0 -> TypographyPage()
                    1 -> ButtonsPage()
                    2 -> ControlsPage()
                    3 -> ContentPage()
                }
            },
            bottomBar = { BottomBar() }
        )
    }
}

@Composable
private fun ContentPage() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Surface(color = MaterialTheme.colors.primary) {
            Column { Content() }
        }
        Surface(color = MaterialTheme.colors.background) {
            Column { Content() }
        }
    }
}

@Composable
private fun BottomBar() {
    BottomAppBar {

    }
}

@Composable
private fun Content() {
    Row {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Card")
        }
    }
}

@Composable
private fun ControlsPage() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Surface(color = MaterialTheme.colors.primary) {
            Column { Controls() }
        }
        Surface(color = MaterialTheme.colors.background) {
            Column { Controls() }
        }
    }
}

@Composable
private fun Controls() {
    val checkboxState = remember { mutableStateOf(true) }
    val radioState = remember { mutableStateOf(true) }
    val switchState = remember { mutableStateOf(true) }
    val textFieldState = remember { mutableStateOf("") }
    val sliderState = remember { mutableStateOf(0f) }
    Row {
        Checkbox(checkboxState.value, { checkboxState.value = it })
        RadioButton(radioState.value, { radioState.value = !radioState.value })
        Switch(switchState.value, { switchState.value = it })
    }
    Row {
        OutlinedTextField(
            textFieldState.value,
            { textFieldState.value = it },
            label = { Text("Label") },
            placeholder = { Text("Placeholder") }
        )
    }
    Row {
        Slider(
            sliderState.value,
            { sliderState.value = it },
            valueRange = 1f..5f,
            steps = 5
        )
    }
    Row {
        Checkbox(checkboxState.value, { checkboxState.value = it }, enabled = false)
        RadioButton(radioState.value, { radioState.value = !radioState.value }, enabled = false)
        Switch(switchState.value, { switchState.value = it }, enabled = false)
    }
    Row {
        TextField(
            textFieldState.value,
            { textFieldState.value = it },
            enabled = false,
            label = { Text("Label Disabled") },
            placeholder = { Text("Placeholder Disabled") })
    }
    Row {
        Slider(
            sliderState.value,
            { sliderState.value = it },
            enabled = false,
            valueRange = 1f..5f,
            steps = 5
        )
    }
}

@Composable
private fun ButtonsPage() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Surface(color = MaterialTheme.colors.primary) {
            Column { Buttons() }
        }
        Surface(color = MaterialTheme.colors.background) {
            Column { Buttons() }
        }
    }
}

@Composable
private fun Buttons() {
    Row {
        Button(onClick = { }) {
            Text("Button")
        }
        OutlinedButton(onClick = { }) {
            Text("OutlinedButton")
        }
        TextButton(onClick = { }) {
            Text("TextButton")
        }
    }
    Row {
        Button(onClick = { }, enabled = false) {
            Text("Button")
        }
        OutlinedButton(onClick = { }, enabled = false) {
            Text("OutlineButton")
        }
        TextButton(onClick = { }, enabled = false) {
            Text("TextButton")
        }
    }
}

@Composable
private fun TypographyPage() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Row {
            Surface(color = MaterialTheme.colors.surface) {
                TextPage()
            }
            Surface(color = MaterialTheme.colors.primary) {
                TextPage()
            }
            Surface(color = MaterialTheme.colors.background) {
                TextPage()
            }
        }
    }
}

@Composable
private fun TextPage() {
    Column {
        Text(text = "H1", style = MaterialTheme.typography.h1)
        Text(text = "H2", style = MaterialTheme.typography.h2)
        Text(text = "H3", style = MaterialTheme.typography.h3)
        Text(text = "H4", style = MaterialTheme.typography.h4)
        Text(text = "H5", style = MaterialTheme.typography.h5)
        Text(text = "H6", style = MaterialTheme.typography.h6)
        Text(text = "Body1", style = MaterialTheme.typography.body1)
        Text(text = "Body2", style = MaterialTheme.typography.body2)
        Text(text = "Button", style = MaterialTheme.typography.button)
        Text(text = "Caption", style = MaterialTheme.typography.caption)
        Text(text = "Overline", style = MaterialTheme.typography.overline)
        Text(text = "Subtitle1", style = MaterialTheme.typography.subtitle1)
        Text(text = "Subtitle2", style = MaterialTheme.typography.subtitle2)
    }
}