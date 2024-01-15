package com.example.cooking.UI.Profile

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.cooking.R


@Composable
fun MyPrivacy(onNavigateToPrivacyPolicy: () -> Unit) {
        Button(
            modifier = Modifier.padding(70.dp),
            onClick = onNavigateToPrivacyPolicy
        ) {
            Text("Privacy", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        }
    }


@Composable
fun MyHelp(onNavigateToHelpPage: () -> Unit) {
        Button(
            modifier = Modifier.padding(10.dp),
            onClick = onNavigateToHelpPage
        ) {
            Text("Help", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        }
    }




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileBox(onNavigateToHelpPage:() -> Unit,onNavigateToPrivacyPolicy: () -> Unit){





    val notification = rememberSaveable{ mutableStateOf("") }
    if (notification.value.isNotEmpty()) {
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }

    var name by rememberSaveable { mutableStateOf("Default Name") }
    var email by rememberSaveable { mutableStateOf("Default Email") }


    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(color = Color(0xFFB8C75E))
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Account Settings", fontSize = 20.sp)
            Text(text = "Logout", modifier = Modifier.clickable { notification.value = "You logged out"  })


        }

        ProfileImage()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp), verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Name", modifier = Modifier.width(100.dp))
            TextField(value = name, onValueChange = {name = it} )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp), verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Email", modifier = Modifier.width(100.dp))
            TextField(value = email, onValueChange = {email = it} )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            FavouriteImage()
            CommentImage()
            CreateImage()


        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
            verticalArrangement = Arrangement.SpaceEvenly) {
            MyHelp(onNavigateToHelpPage)
            Spacer(modifier = Modifier.height(10.dp))
            MyPrivacy(onNavigateToPrivacyPolicy)
        }


    }

}
@Composable
fun ProfileButtons(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(60.dp)

    ){
        Spacer(modifier = Modifier.height(20.dp))
        MyHelp(onNavigateToHelpPage = {})
        Spacer(modifier = Modifier.height(20.dp))
        MyPrivacy(onNavigateToPrivacyPolicy = {})}
}




@Preview
@Composable
fun PreviewBox(){
    ProfileBox(onNavigateToHelpPage = {}, onNavigateToPrivacyPolicy = {})
}


@Composable
fun ProfileImage() {
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.profilefic
        else
            imageUri.value
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){ uri: Uri? ->
        uri?.let{ imageUri.value = it.toString() }


    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop)

        }
        Text(text = "Change Profile Picture")
    }
}

@Composable
fun CommentImage() {
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.create
        else
            R.drawable.baseline_comment_24
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){ uri: Uri? ->
        uri?.let{ imageUri.value = it.toString() }


    }

    Column(
        //modifier = Modifier
            //.padding(80.dp)
            //.fillMaxWidth(0.33f),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Bottom
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(50.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop)

        }
        Text(text = "Created")
    }
}

@Composable
fun FavouriteImage() {
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.baseline_comment_24
        else
            imageUri.value
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){ uri: Uri? ->
        uri?.let{ imageUri.value = it.toString() }


    }

    Column(
        //modifier = Modifier
            //.padding(80.dp)
            //.fillMaxWidth(0.33f),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Bottom
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(50.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop)

        }
        Text(text = "Comments")
    }
}

@Composable
fun CreateImage() {
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.favourite
        else
            imageUri.value
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){ uri: Uri? ->
        uri?.let{ imageUri.value = it.toString() }


    }

    Column(
       //modifier = Modifier
            //.padding(80.dp)
            //.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
       // verticalArrangement = Arrangement.Bottom
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(50.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop)

        }
        Text(text = "Favourite")
    }
}