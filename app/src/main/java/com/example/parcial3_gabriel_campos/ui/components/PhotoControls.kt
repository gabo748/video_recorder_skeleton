package com.example.parcial3_gabriel_campos.ui.components

import androidx.camera.core.ImageCapture
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FlashlightOff
import androidx.compose.material.icons.filled.FlashlightOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.parcial3_gabriel_campos.CameraViewModel
// Icons.Filled.Refresh
// Icons.Filled.Favorite
// Icons.Filled.FavoriteBorder


@Composable
fun PhotoControls(
    viewModel: CameraViewModel,
    onCapturePhoto: () -> Unit,
    onSwitchCamera: () -> Unit
) {
    val flashMode = viewModel.flashMode.collectAsState().value

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        // Botón de cambio de cámara
        FloatingActionButton(onClick = onSwitchCamera) {
            Icon(Icons.Default.Cameraswitch, contentDescription = "Cambiar cámara")
        }

        // Botón de captura de foto
        FloatingActionButton(onClick = onCapturePhoto) {
            Icon(Icons.Default.Camera, contentDescription = "Capturar foto")
        }

        // Botón de flash
        FloatingActionButton(onClick = viewModel::toggleFlashMode) {
            val icon = when (flashMode) {
                ImageCapture.FLASH_MODE_ON -> Icons.Default.FlashlightOn
                ImageCapture.FLASH_MODE_AUTO -> Icons.Filled.FlashlightOff
                else -> Icons.Default.FlashlightOff
            }
            Icon(icon, contentDescription = "Alternar flash")
        }

    }
}