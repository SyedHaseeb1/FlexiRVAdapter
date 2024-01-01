# FlexiRVAdapter Usage Example

This is an example use-case demonstrating how to utilize the `FlexiRVAdapter` in an activity.


## Installation

### Gradle

Add the following dependency to your project's `build.gradle` file:



### Gradle (Groovy)
```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
```
```
dependencies {
    implementation 'com.github.syedhaseeb1:FlexiRVAdapter:$latestVersion'
}
```

### Gradle (Kotlin KTS)

```KTS

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}
```
```
dependencies {
    implementation("com.github.syedhaseeb1:FlexiRVAdapter:$latestVersion")
}
```
## Usage

```kotlin
// Example use-case in activity
val adapter = FlexiRVAdapter(Your_ItemView_binding::inflate)
adapter.viewHolderBinderCallback = { your_model ->
    val titleStr = your_model.title
    val descStr = your_model.desc

    tvTile.text = titleStr
    tvDesc.text = descStr

    itemView.safeClickListener {
        // handle clicks
    }
}

adapter.updateList(your_list)
your_RV.layoutManager = verticalRv()
your_RV.adapter = adapter

// To refresh adapter with new list:
adapter.submitList(your_new_list)