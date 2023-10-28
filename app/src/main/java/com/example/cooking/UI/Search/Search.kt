package com.example.cooking.UI.Search

import android.text.style.BackgroundColorSpan
import android.widget.GridLayout
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.filament.Box
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.cooking.R






@Preview
@Composable
fun PreviewSearchBar() {
    val (searchQuery, setSearchQuery) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            //.fillMaxSize()
            .fillMaxWidth()

    ) {
        // First Part (SearchBar)
        //SearchBar(modifier = Modifier.weight(1f))
        // Spacer to create a division
        SearchBox(query = searchQuery, onQueryChange = { newQuery ->
            setSearchQuery(newQuery)
        } , onSearch = { /*TODO*/ },
           // active = true, // Or false based on your needs
            //onActiveChange = { isActive ->
                // Handle active state change here
            //}
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp) // Add padding from the top of the screen
                .background(Color.White)

        ) {
            DisplayTextBoxes()
        }

    }
