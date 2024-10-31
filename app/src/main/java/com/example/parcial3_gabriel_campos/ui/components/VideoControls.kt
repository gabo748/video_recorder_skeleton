package com.example.parcial3_gabriel_campos.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FlashlightOff
import androidx.compose.material.icons.filled.FlashlightOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Stop
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Icons.Filled.Refresh
//Icons.Filled.Close else Icons.Filled.PlayArrow

@Composable
fun VideoControls(
    onRecordVideo: (Boolean) -> Unit,
    onSwitchCamera: () -> Unit,
    onToggleFlash: (Boolean) -> Unit // Nueva función para alternar el flash
) {
    var isRecording by remember { mutableStateOf(false) }
    var isFlashOn by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            // Botón de cambio de cámara
            FloatingActionButton(
                onClick = onSwitchCamera,
                modifier = Modifier.size(80.dp),
                backgroundColor = Color.Green
            ) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "Cambiar cámara",
                    tint = Color.Black,
                    modifier = Modifier.size(40.dp)
                )
            }

            // Botón de grabación/parada
            FloatingActionButton(
                onClick = {
                    isRecording = !isRecording
                    onRecordVideo(isRecording)
                },
                modifier = Modifier.size(80.dp),
                backgroundColor = if (isRecording) Color.Red else Color.Gray
            ) {
                Icon(
                    imageVector = if (isRecording) Icons.Filled.Stop else Icons.Filled.PlayArrow,
                    contentDescription = if (isRecording) "Detener grabación" else "Iniciar grabación",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }

            // Botón de flash
            FloatingActionButton(
                onClick = {
                    isFlashOn = !isFlashOn
                    onToggleFlash(isFlashOn)
                },
                modifier = Modifier.size(80.dp),
                backgroundColor = if (isFlashOn) Color.Yellow else Color.Gray
            ) {
                Icon(
                    imageVector = if (isFlashOn) Icons.Filled.FlashlightOn else Icons.Filled.FlashlightOff,
                    contentDescription = "Alternar flash",
                    tint = Color.Black,
                    modifier = Modifier.size(40.dp)
                )
            }

        }

        if (!isRecording) {
            Text(
                text = "Toque para grabar",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 120.dp)
            )
        }
    }
}