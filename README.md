# todayList 今日清單

一個使用 Kotlin + Jetpack Compose 開發的簡易 Android 待辦事項 App，顯示今天日期與待辦清單。

## 功能

- 顯示今天的日期（格式：`yyyy 年 M 月 d 日 (E)`，繁體中文 / zh-TW）
- 待辦清單（預設項目：丟垃圾、洗碗）
- 每筆項目可透過 Checkbox 勾選完成狀態

## 技術棧

- **語言**：Kotlin
- **UI**：Jetpack Compose（Material 3）
- **架構**：單一 `ComponentActivity` + Composable
- **Compose BOM**：`2026.03.00`
- **Android Gradle Plugin**：`9.1.0`
- **Kotlin Compose Plugin**：`2.3.20`
- **Gradle**：`9.4.1`
- **compileSdk / targetSdk**：`36`
- **minSdk**：`26`
- **Java / JVM target**：`17`

## 專案結構

```
todayList/
├── build.gradle.kts            # Root 專案設定
├── settings.gradle.kts         # 專案模組與 repo 設定
├── gradle.properties           # Gradle 屬性（含 parallel、caching、configuration-cache）
├── gradle/wrapper/
│   └── gradle-wrapper.properties
└── app/
    ├── build.gradle.kts        # App module 設定
    └── src/main/
        ├── AndroidManifest.xml
        ├── res/values/
        │   ├── strings.xml     # app_name: 今日清單
        │   └── themes.xml
        └── java/com/example/todaylist/
            └── MainActivity.kt # 主畫面 Compose 程式碼
```

## 主要檔案說明

### `MainActivity.kt`
- `TodoItem` data class：`id`、`title`、`isCompleted`
- `MainActivity`：`ComponentActivity`，在 `setContent` 中掛載 `TodayListScreen`
- `TodayListScreen()`：使用 `Scaffold` + `TopAppBar`，顯示日期與 `LazyColumn` 清單
- `TodayListPreview()`：`@Preview` Composable，方便在 Android Studio 預覽

### 預設待辦項目
```kotlin
TodoItem(1, "丟垃圾")
TodoItem(2, "洗碗")
```

## 如何執行

1. 用 Android Studio（建議 Hedgehog 以上，能支援對應的 AGP 版本）開啟 `/Users/jimmy/work/todayList` 資料夾
2. 等 Gradle sync 完成
3. 選擇模擬器或實體裝置後按 Run

或使用命令列：

```bash
cd /Users/jimmy/work/todayList
./gradlew :app:installDebug
```

> 註：首次執行前需自行產生 `gradlew` wrapper script（`gradle wrapper` 或由 Android Studio 自動產生）。

## 後續可擴充方向

- 新增／刪除待辦項目
- 使用 Room 或 DataStore 做本機持久化
- 依日期分頁瀏覽過去的清單
- 加入通知提醒
