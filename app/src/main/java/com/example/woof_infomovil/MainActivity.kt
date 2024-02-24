package com.example.woof_infomovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.woof_infomovil.data.Dog
import com.example.woof_infomovil.data.dogs
import com.example.woof_infomovil.ui.theme.Woof_INFOMOVILTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Woof_INFOMOVILTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    WoofApp()
                }
            }
        }
    }
}

@Composable
fun WoofApp() {
    LazyColumn{
        items(dogs){
            DogItem(dog = it)
        }
    }
}

@Composable
fun DogItem(
    dog: Dog,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        DogIcon(dog.imageResourceId)
        DogInfo(dog.name, dog.age)
    }

}

@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp),
        painter = painterResource(dogIcon),
        contentDescription = null
    )
}

@Composable
fun DogInfo(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier){
        Text(
            text = stringResource(dogName),
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(R.string.years_old, dogAge)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WoofPreview() {
    Woof_INFOMOVILTheme (darkTheme = false){
        WoofApp()
    }
}