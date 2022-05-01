# Activity Launcher

Activity Launcher 是 StartActivityForResult 的终极解决方案，真正意义上的一行代码搞定。

![activity-launcher](docs/activity-launcher.png)

## 目录

- [背景](#背景)
- [使用](#使用)
  - [添加依赖](#添加依赖)
  - [Kotlin 使用](#kotlin-使用)
  - [Java 使用](#java-使用)
- [ActivityResultContracts](#activityresultcontracts)
- [自定义 ActivityResultContract](#自定义-activityresultcontract)
- [原理简介](#原理简介)

## 背景

想要启动一个 Activity，并且需要知道其处理的结果时候，我们一般会这么写：

```kotlin
class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ...
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            setType("image/*")
        }
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode != REQUEST_CODE) return

        if (resultCode == RESULT_OK) {
            // 处理返回成功的情况
        } else if (resultCode == RESULT_CANCELED) {
            // 处理取消的情况
        }
    }
}
```

这种写法会有几个问题：

1. 调用逻辑与结果回调不在同一个地方，逻辑比较割裂，不易维护；
2. 如果当前 Activity 中有多个返回结果的时候，会存在 `requestCode` 与 `resultCode` 双层嵌套的问题，不易维护；
3. 如有多处需要启动对应的 Activity，那么 `Intent` 的构造以及结果处理的逻辑就会有多份，存在重复代码；

为了优化上述问题，官方给出了新的解决方案，如下：

```kotlin
class MainActivity : AppCompatActivity() {

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            // 处理返回的数据
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ...
        val selectButton = findViewById<Button>(R.id.select_button)
        selectButton.setOnClickListener {
            // 跳转到对应的 Activity 中
            getContent.launch("image/*")
        }
    }
}
```

上述代码虽然解决了部分问题，但是仍然会有调用与结果处理不在同一处的情况，对代码的可读性有一定的影响。

为了解决上述问题，特封装此库，使用非常简单：

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ...

        ActivityLauncher.getContents(activityResultRegistry).launch("image/*") { uri: Uri? ->
            // 处理返回的数据
        }
    }
}
```

基本是一行代码搞定。

## 使用

### 添加依赖

```kotlin
dependencies {
    // normal & java
    implementation("com.madroid.activity:launcher:${last_version}")
    // Kotlin Coroutines & ktx
    implementation("com.madroid.activity:launcher-ktx:${last_version}")
}
```

### Kotlin 使用

```kotlin
private fun getContents() {
    val type = "image/*"
    ActivityLauncher.getContents(activityResultRegistry).launch(type) { uri: Uri? ->
        // Handle the returned Uri
    }
}
```

也对 Activity、Fragment 中添加了一些扩展函数，以简化上面的写法，如下：

```kotlin
private fun getContents() {
    launchGetContents(type, null) { uri ->
        // Handle the returned Uri
    }
}
```

如果项目中已经在使用协程的话，也可以采用如下方式：

```kotlin
private fun getContents() {
    val uri = awaitGetContents(type, null)
    // Handle the returned Uri
}
```

### Java 使用

如果项目中还没有使用 Kotlin 语言，此库也是兼容 Java 语言调用的，如下：

```java
public class ActivityLauncherJavaSample {

    void getContents(ActivityResultRegistry registry) {
        String type = "image/*";
        ActivityLauncher.getContents(registry).launch(type, new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                // handle result
            }
        });
        // 也可以使用 lambda 简化写法
        ActivityLauncher.getContents(registry).launch(type, result -> {
            // handle result
        });
    }
}
```

## ActivityResultContracts

目前改库中以及支持了系统自带的多种 `ActivityResultContract`，主要有：

- `ActivityResultContracts.CreateDocument()`
- `ActivityResultContracts.GetContent()`
- `ActivityResultContracts.GetMultipleContents()`
- `ActivityResultContracts.OpenDocument()`
- `ActivityResultContracts.OpenDocumentTree()`
- `ActivityResultContracts.OpenMultipleDocuments()`
- `ActivityResultContracts.PickContact()`
- `ActivityResultContracts.RequestMultiplePermissions()`
- `ActivityResultContracts.RequestPermission()`
- `ActivityResultContracts.StartActivityForResult()`
- `ActivityResultContracts.StartIntentSenderForResult()`
- `ActivityResultContracts.TakePicture()`
- `ActivityResultContracts.TakePicturePreview()`
- `ActivityResultContracts.TakeVideo()`

更多详细内容，可在 [ActivityLauncher](/launcher/src/main/java/com/madroid/activity/launcher/ActivityLauncher.kt)
中查看。

## 自定义 ActivityResultContract

有些场景官方的 ActivityResultContracts 中并没有定义，也可以才用自定义的方式实现，以开启蓝牙为例，首先定义定义的 Contract

```kotlin
/**
 * 开启蓝牙
 * https://developer.android.com/guide/topics/connectivity/bluetooth#SettingUp
 */
class BleActivityResultContract : ActivityResultContract<Unit?, Boolean>() {
    override fun createIntent(context: Context, input: Unit?): Intent {
        return Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Boolean {
        return resultCode == Activity.RESULT_OK
    }
}
```

使用已定义的 BleActivityResultContract

```kotlin
    private fun enableBle() {
    ActivityLauncher.startWithContract(activityResultRegistry, BleActivityResultContract())
        .launch(null) { isEnable ->

        }
}
```

想要进一步简化上面的写法，也可以对 ActivityLauncher 定义扩展函数，大致如下：

```kotlin
fun ActivityLauncher.enableBle(
    registry: ActivityResultRegistry,
    callback: ActivityResultCallback<Boolean>
) {
    startWithContract(registry, BleActivityResultContract()).launch(null, callback)
}
```

使用方式可以调整为：

```kotlin
    private fun enableBleWithKtx() {
    ActivityLauncher.enableBle(activityResultRegistry) { isEnable ->

    }
}
```

如在自己的业务中有 `StartActivityForResult` 的场景，可以按照上述方式进行简单封装。

## 原理简介

社区中也有类似的 SDK 封装，但是基本都需要在 `onStarted` 之前进行初始化，类型于官方的 `registerForActivityResult` 方式，其原因在与 SDK 内部实现有强制要求，否则将会抛出异常，代码如下：

```java
    @NonNull
public final<I, O> ActivityResultLauncher<I> register(
@NonNull final String key,
@NonNull final LifecycleOwner lifecycleOwner,
@NonNull final ActivityResultContract<I, O> contract,
@NonNull final ActivityResultCallback<O> callback){

        Lifecycle lifecycle=lifecycleOwner.getLifecycle();

        if(lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)){
        throw new IllegalStateException("LifecycleOwner "+lifecycleOwner+" is "
        +"attempting to register while current state is "
        +lifecycle.getCurrentState()+". LifecycleOwners must call register before "
        +"they are STARTED.");
        }
        
        // ...
        }
```
其内部会在生命周期的 onDestroy 中状态进行 unregister 操作，释放内相关存。

其实，除了带有 LifecycleOwner 的 register 函数外，还有一个不带 LifecycleOwner 的函数，所以其内部也没有对生命周期相关的判断了，
但是需要我们自己管理其 unregister 的调用，本库采用的就是这种方式。实现思路就是在结果回来的时候主动调用 unregister，所以本库并不支持在 Launcher 的多次调用。 
具体实现方式见 [LauncherImpl](launcher/src/main/java/com/madroid/activity/launcher/api/LauncherImpl.kt) 。
