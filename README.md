# 🎲 Desk - 桌遊店桌況收銀管理系統

## 專案介紹

Desk 是一套使用 Java Swing 開發的桌遊店管理系統，提供桌況監控與簡易收銀功能。

系統可同時管理四張桌子，記錄顧客進場時間、停留時間，並依照消費時數自動產生結帳金額。

## 功能特色

- 新增顧客進場
- 顯示進場時間
- 即時計算停留時間
- 刪除指定顧客
- 四桌獨立管理
- 自動結帳計算

## 專案架構

```text
Desk/
│
├─ src/
│   └─ desk/
│       ├─ Customer.java
│       └─ Tables.java
│
├─ bin/
├─ .project
└─ .classpath
```

## 使用技術

- Java
- Java Swing
- Event Listener
- LocalDateTime
- Duration API
- OOP

## 執行方式

### Eclipse

1. 匯入 Existing Java Project
2. 選擇專案資料夾
3. 執行 `Tables.java`

### 命令列

```bash
javac src/desk/*.java
java desk.Tables
```

## 未來可擴充功能

- 資料庫儲存
- 會員系統
- 餐點點餐功能
- 每日營收統計
- Excel 報表匯出

## 作者

Java Swing GUI Application
