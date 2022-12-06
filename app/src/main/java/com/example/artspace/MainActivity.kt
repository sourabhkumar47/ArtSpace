package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        image()
        Spacer(Modifier.height(16.dp))

        TextBox(R.string.title)
        TextBox(R.string.subHeading)

        Spacer(Modifier.height(16.dp))

        ButtonRow()
    }
}

@Composable
fun image(
    modifier: Modifier = Modifier
) {

    Image(
        painter = painterResource(id = R.drawable.pexels_james_wheeler_1598073),
        contentDescription = null,
        modifier
            .clip(
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
    )
}

@Composable
fun TextBox(
    @StringRes label: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(label),
            fontSize = 24.sp
        )
    }
}

@Composable
fun ButtonRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = {}) {
            Text(text = "Previous")
        }

        Spacer(Modifier.width(16.dp))

        Button(onClick = {}) {
            Modifier.width(100.dp)
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}