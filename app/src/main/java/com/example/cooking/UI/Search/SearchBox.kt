package com.example.cooking.UI.Search

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.google.android.material.search.SearchBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun SearchBox(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector = Icons.Outlined.Search
) {
    var text by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }
    TextField(
        value = query,
        onValueChange = {
            onQueryChange(it)
        },
        //value = text,
        shape = RoundedCornerShape(20.dp),
        /*onValueChange = { newValue ->
            text = newValue
            onQueryChange(newValue)
        },*/
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
            //keyboardType = KeyboardType.Text
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(query)
            }
        ),
        textStyle = TextStyle(color = Color.Black , fontSize = 22.sp), // Adjust the text color as needed
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = Color.Black
            )
        },
       trailingIcon = {

           if (query.isNotEmpty()) {
               Icon(
                   imageVector = Icons.Default.Close,
                   contentDescription = null,
                   tint = Color.Black,
                   modifier = Modifier.clickable {
                       onQueryChange("")
                   }
               )
           }
        },

        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .testTag("searchtext")
    )
}

