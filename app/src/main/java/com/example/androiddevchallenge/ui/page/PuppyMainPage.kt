/*
 *
 *  * Copyright 2021 The Android Open Source Project
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     https://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.example.androiddevchallenge.ui.page

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.viewmodel.PuppyViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.PuppyList

@Composable
fun PuppyMainPage(
    navController: NavHostController,
    puppiesListViewModel: PuppyViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppy List") },
            )
        }
    ) {
        val puppyItems: State<List<Puppy>> =
            puppiesListViewModel.puppyList.observeAsState(emptyList())
        PuppyList(
            puppyItems = puppyItems.value,
            onSelected = { puppy ->
                navController.navigate("detail/${puppy.id}") {
                    anim {
                        enter = android.R.anim.slide_in_left
                        exit = android.R.anim.slide_out_right
                        popEnter = android.R.anim.slide_in_left
                        popExit = android.R.anim.slide_out_right
                    }
                }
            }
        )
    }
}