package com.rujirakongsomran.jc_aleartdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rujirakongsomran.jc_aleartdialog.ui.theme.JC_AleartDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_AleartDialogTheme {
                AlertDialogSample()
            }
        }
    }
}

@Composable
fun AlertDialogSample() {
    val openDialog = remember { mutableStateOf(false) }
    val backgroundColor = remember { mutableStateOf(Color(0xFFF5F5F5)) }

    Column(
        modifier = Modifier
            .background(backgroundColor.value)
            .fillMaxSize()
    ) {
        Button(
            onClick = {
                openDialog.value = true
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Show Dialog")
        }

        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                title = {
                    Text(text = "Title")
                },
                text = {
                    Text(
                        "This area typically contains the supportive text " +
                                "which presents the details regarding the Dialog's purpose."
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }
                    ) {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }
                    ) {
                        Text(text = "Dismiss")
                    }
                }
            )
        }

    }
}

@Preview
@Composable
fun CreateAlertDialogPreview() {
    JC_AleartDialogTheme {
        AlertDialogSample()
    }
}