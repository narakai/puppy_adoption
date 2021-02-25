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

package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class Puppy(
    val id: Int,
    val name: String,
    val breed: String,
    val description: String,
    val age: String,
    @DrawableRes val drawableRes: Int
)

val samplePuppyList = listOf(
    Puppy(
        1,
        "Jimmy",
        "Chihuahua",
        "The Chihuahua dog breed‘s charms include their small size, big personality, and variety in coat types and colors.",
        "5 months old",
        R.drawable.chihuahua
    ),
    Puppy(
        2,
        "Leon",
        "Pekinese",
        "The Pekingese, a compact toy companion of regal bearing and a distinctive rolling gait, is one of several breeds created for the ruling classes of ancient China.",
        "3 months old",
        R.drawable.pekinese
    ),
    Puppy(
        3,
        "Mike",
        "Pembroke",
        "Originally bred to herd cattle, sheep, and horses, the Pembroke is an active and intelligent dog breed.",
        "4 months old",
        R.drawable.pembroke
    ),
    Puppy(
        4,
        "Mongo",
        "Cardigan",
        "The Cardigan is one of two separate dog breeds known as Welsh Corgis that originated in Wales; the other is the Pembroke Welsh Corgi.",
        "2 months old",
        R.drawable.cardigan
    ),
    Puppy(
        5,
        "Jessica",
        "Leonberger",
        "The Leonberger is a dog breed, whose name derives from the city of Leonberg in Baden-Württemberg, Germany. ",
        "3 months old",
        R.drawable.leonberg
    ),
    Puppy(
        6,
        "Super Man",
        "Newfoundland",
        "The Newfoundland is a large, strong dog breed from Newfoundland. They were originally used as a working dog to pull nets for fishermen and haul wood from the forest. ",
        "6 months old",
        R.drawable.newfoundland
    ),
)