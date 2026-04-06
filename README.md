# 📋 todayList 今日清單

一個簡潔的 Android 待辦事項 App，用 Kotlin + Jetpack Compose 打造。打開就看到今天日期和待辦清單，勾選即完成。

## 功能

- 自動顯示今天日期（繁體中文格式：`2026 年 4 月 6 日 (日)`）
- 待辦清單，Checkbox 勾選切換完成狀態
- Material 3 設計風格

## 截圖

```
┌─────────────────────┐
│  今日清單            │
├─────────────────────┤
│                     │
│  2026 年 4 月 6 日 (日) │
│                     │
│  ☐ 丟垃圾           │
│  ☑ 洗碗             │
│                     │
└─────────────────────┘
```

## 技術棧

| 項目 | 版本 |
|---|---|
| Kotlin | + Compose Plugin `2.3.20` |
| UI | Jetpack Compose + Material 3 |
| Compose BOM | `2026.03.00` |
| Android Gradle Plugin | `9.1.0` |
| compileSdk / targetSdk | `36` |
| minSdk | `26` |
| JVM Target | `17` |

## 快速開始

### Android Studio

1. Clone 專案
   ```bash
   git clone https://github.com/tsao66/todayList.git
   ```
2. 用 Android Studio 開啟專案資料夾
3. 等 Gradle Sync 完成
4. 選擇模擬器或實體裝置 → Run

### 命令列

```bash
git clone https://github.com/tsao66/todayList.git
cd todayList
./gradlew :app:installDebug
```

## 專案結構

```
todayList/
├── build.gradle.kts                # Root 設定
├── settings.gradle.kts             # 模組與 repo 設定
├── gradle.properties               # Gradle 屬性
└── app/
    ├── build.gradle.kts            # App module 設定
    └── src/main/
        ├── AndroidManifest.xml
        ├── res/
        │   ├── values/strings.xml  # app_name: 今日清單
        │   └── values/themes.xml
        └── java/.../todaylist/
            └── MainActivity.kt     # 主畫面（唯一檔案）
```

## 核心程式碼

整個 App 只有一個檔案 `MainActivity.kt`：

- `TodoItem` — data class（id, title, isCompleted）
- `TodayListScreen()` — 主畫面 Composable，包含日期顯示 + LazyColumn 清單
- 使用 `remember { mutableStateOf(...) }` 管理勾選狀態

## 後續可擴充

- [ ] 新增 / 刪除待辦項目
- [ ] Room 或 DataStore 做本機持久化
- [ ] 依日期分頁瀏覽歷史清單
- [ ] 推播通知提醒

## License

MIT
