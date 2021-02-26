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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.samplePuppyList

@Composable
fun PuppyListItem(puppy: Puppy, onSelected: () -> Unit) {
    Box(modifier = Modifier.padding(4.dp)) {
        Card(
            elevation = 2.dp,
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Row(
                modifier = Modifier
                    .clickable(onClick = onSelected)
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                val image: Painter = painterResource(id = puppy.drawableRes)
                Image(
                    painter = image,
                    contentDescription = puppy.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.aspectRatio(1f)
                )
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = puppy.name,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onSurface
                    )
                    Text(
                        text = "${puppy.age} - ${puppy.breed}",
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onSurface
                    )
                }
            }
        }
    }
}

@Preview()
@Composable
fun SamplePuppyItem() {
    PuppyListItem(puppy = samplePuppyList.first(), onSelected = {})
}
