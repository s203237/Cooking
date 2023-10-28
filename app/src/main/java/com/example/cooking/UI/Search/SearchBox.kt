package com.example.cooking.UI.Search

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.search.SearchBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun SearchBox(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
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
        value = text,
        shape = RoundedCornerShape(20.dp),
        onValueChange = { newValue ->
            text = newValue
            onQueryChange(newValue)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch()
            }
        ),
        textStyle = TextStyle(color = Color.Black), // Adjust the text color as needed
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = Color.Gray
            )
        },
       trailingIcon = {
            /*Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                tint = Color.Gray
            )*/
           if (query.isNotEmpty()) {
               Icon(
                   imageVector = Icons.Default.Close,
                   contentDescription = null,
                   tint = Color.Gray,
                   modifier = Modifier.clickable {
                       onQueryChange("")
                   }
               )
           }
        },

        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

/*@Composable
fun SearchBox(){
    var text by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }

    Scaffold{
   SearchBar(
       modifier = Modifier.fillMaxWidth(),
       query = text,
       onQueryChange ={
           text = it.toString()
       },
       onSearch = {
           active = false
       },
       active = active,
       onActiveChange ={
           active = it
       }
   )
    }

}*/
/*@Composable
fun SearchBar(
    //search: String ,
    // onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    //onSearchSubmit: () ->Unit ={}
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        var search by remember { mutableStateOf(TextFieldValue()) }
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(30.dp)
                .background(color = Color.White),
            contentAlignment = Alignment.TopCenter

        ) {
            TextField(
                value = search,
                onValueChange = { text -> search = text },
                singleLine = true,
                textStyle = TextStyle(fontSize = 24.sp),

                placeholder = {
                    Text(
                        text = "What do you want to cook?",
                        color = Color.DarkGray

                    )
                },
                shape = RoundedCornerShape(50),
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = null,
                        tint = Color.DarkGray
                    )

                }
            )
        }

    }

}*/