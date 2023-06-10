<h1 align="center"> Overwatch Guide </h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=26"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://kotlinlang.org"><img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-1.8.xx-blue"/></a>
  <img alt="MVVM" src="https://img.shields.io/badge/MVVM-Architecture-orange"/>
  <a href="https://developer.android.com/kotlin/coroutines"><img alt="Coroutines" src="https://img.shields.io/badge/Coroutines-Asynchronous-red"/></a>
</p>

<p align="center">
  <img src="https://github.com/marlonsantini/Overwatch/blob/master/screenshots/heroesScreen.png" width="300"><br>
</p>

<p align="center">
A sample android app consuming Overwatch API to display overwatch heroes, maps and patchs, it has been built with Architecture Components and MVVM pattern.
</p>

<p align="center">
  <img src="https://github.com/marlonsantini/Valorant/blob/master/screenshots/GooglePlay.png" width="300"><br>
  <a href="https://play.google.com/store/apps/details?id=fingerfire.com.overwatch">OverGuide</a>
</p>

## Tech stack & Open-source libraries
- Minimum SDK level 26
- [Kotlin](https://kotlinlang.org/)
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Koin](https://insert-koin.io) - For dependency injection.
- [Firebase](https://firebase.google.com/) - For Crashlytics and Analytics
- [Admob](https://admob.google.com/)
- [Exoplayer](https://github.com/google/ExoPlayer) - ExoPlayer is an application level media player for Android.
- [JetPack](https://developer.android.com/jetpack)
  - LiveData - Notify domain layer data to views.
  - Lifecycle - Dispose of observing data when lifecycle state changes.
  - Fragment-ktx - A set of Kotlin extensions that helps with fragment lifecycle.
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Allows you to more easily write code that interacts with views
  - ViewModel - UI related data holder, lifecycle aware.
  - Navigator - Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app.
- Architecture
  - Multi-module design for the app.
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - Repository pattern (NetworkBoundResource)
  - Clean Architecture approach.
- [Gradle KotlinDsl](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - Construct the REST APIs.
- [Gson](https://github.com/google/gson) - Gson is a Java library that can be used to convert Java Objects into their JSON.
- [Coil](https://coil-kt.github.io/coil/) - For Loading images from Urls.

## Architecture
OverGuide is Multi-modular application with a meaningful separation for layers and features with the necessary grouping.
With MVVM architecture with an additional Domain layer for each module by itself.

Modules Design:
- App
  - Api
  - Di
  - Extensions
  - Network
  - Features
      - Heroes
        - Data
          - Repository
          - Response
        - Di
        - Ui
          - Adapter
          - ViewState
      - Maps
        - Data
          - Repository
          - Response
        - Di
        - Ui
          - Adapter
          - ViewState
      - Patchs
        - Data
          - Repository
          - Response
        - Di
        - Ui
          - Adapter
          - ViewState

## In progress 🚧.
- [ ] Write tests
- [ ] Implement feature strong x week
- [ ] Patch screen improvement
- [ ] Code cleanup

# License
```xml
Designed and developed by .fingerfire - 2023 

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
