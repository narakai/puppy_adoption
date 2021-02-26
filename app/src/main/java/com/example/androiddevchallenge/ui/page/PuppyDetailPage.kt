/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.viewmodel.PuppyViewModel

@Composable
fun PuppyDetailsPage(
    puppyId: Int,
    navController: NavHostController,
    puppyViewModel: PuppyViewModel = viewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppy Detail") },
                navigationIcon =
                {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            androidx.compose.material.icons.Icons.Outlined.ArrowBack,
                            "back"
                        )
                    }
                }
            )
        }
    ) {
        val puppyList: State<List<Puppy>> = puppyViewModel.puppyList.observeAsState(emptyList())
        puppyList.value.firstOrNull { it.id == puppyId }?.let {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                val image: Painter = painterResource(id = it.drawableRes)
                Image(
                    painter = image,
                    contentDescription = it.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.aspectRatio(1.5f)
                )
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onSurface,
                    )
                    Text(
                        text = """
                     Age: ${it.age}
                     Breed: ${it.breed}
                        """.trimIndent(),
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onSurface,
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Description:",
                        style = MaterialTheme.typography.overline,
                        color = MaterialTheme.colors.onSurface,
                    )
                    Text(
                        text = it.description,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface,
                    )
                }
            }
        }
    }
}
