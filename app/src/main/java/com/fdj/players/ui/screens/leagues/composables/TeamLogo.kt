//Composable function to render the team logo
package com.fdj.players.ui.screens.leagues.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.fdj.players.R

class TeamLogo {

    /**
     * Composable function to render the team logo when the logo URL is not empty.
     *
     * @param logoUrl The URL of the team logo.
     * @param width The width of the team logo.
     * @param height The height of the team logo.
     */
    @Composable
    fun notEmptyLogo(logoUrl: String?, width: Dp, height: Dp) {
        if (logoUrl != null) {
            val imagePainter = rememberImagePainter(data = logoUrl)
            Box(
                modifier = Modifier
                    .size(width = width, height = height)
                    .padding(1.dp)
            ) {
                Image(
                    painter = imagePainter,
                    contentDescription = "Team Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
        } else {
            // Handle the case when the logoUrl is null
            emptyLogo(width = width, height = height)
        }
    }

    /**
     * Composable function to render the team logo when the logo URL is empty or null.
     *
     * @param width The width of the team logo.
     * @param height The height of the team logo.
     */
    @Composable
    fun emptyLogo(width: Dp, height: Dp) {
        val logoDrawable = painterResource(R.drawable.empty_logo)
        Box(
            modifier = Modifier
                .size(width = width, height = height)
                .padding(1.dp)
        ) {
            Image(
                painter = logoDrawable,
                contentDescription = "Team Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}