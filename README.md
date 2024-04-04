# FlexiRVAdapter
FlexiRVAdapter is an enhanced RecyclerView adapter based on ListAdapter, designed to adapt to any kind of item view provided for RecyclerView items. It provides flexibility and ease of use for adapting different types of data items in RecyclerViews.

## Usage
To use FlexiRVAdapter in your project, follow these steps:

* Define your RecyclerView item view binding using a layout file with view binding enabled.
* Initialize FlexiRVAdapter with your * item view binding function.
* Implement the viewHolderBinderCallback to bind data to your item views.
* Submit your data list to the adapter using submitList() or updateList().

Here's an example use-case in an activity:
```
private lateinit var adapter: FlexiRVAdapter<FileModel, AudioListViewBinding>

adapter = FlexiRVAdapter(AudioListViewBinding::inflate)
adapter.viewHolderBinderCallback = { fileModel ->
    val filePath = fileModel.filePath
    val fileName = fileModel.name
    val fileDuration = fileModel.duration
    val fileSize = fileModel.size
    tvFileName.text = fileName
    tvSize.text = fileSize
    tvDuration.text = fileDuration
    itemView.safeClickListener {
        routeWithData(filePath, MainActivity::class.java)
    }
}
adapter.submitList(audioList)

your_RV.layoutManager = verticalRv()
your_RV.adapter = adapter

// To refresh adapter with new list:
adapter.submitList(your_new_list)

```

## Installation

### Gradle
Add the following dependency to your project's build.gradle file:

#### Groovy (build.gradle)
```
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
#### Kotlin DSL (build.gradle.kts)
```
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
## Screenshot

The screenshot below demonstrates multiple RecyclerViews with different layouts, all handled by the same FlexiRVAdapter class.
* Icon View layout
* Image View layout
* Rec View layout
* Grid View layout

![Screenshot](/screenshots/FlexiRvAdapter.png)

## Contributing

If you'd like to contribute to this project, please follow the [Contribution Guidelines](CONTRIBUTING.md).


## License

This project is licensed under the [GNU General Public License, Version 3.0](http://www.gnu.org/licenses/#GPL). Any fork of
this project is requested to maintain the same license as per the law.

Please see the [LICENSE](LICENSE.md) file for full reference.
