# description
掲示板サービスのバックエンドと最小限のフロントエンド

# todo
- [ ] docker support
- [ ] frontend
- [ ] performance optimization

# ドキュメント
## bbsデータディレクトリ構造
```
.
└── data/
    └── bbs/
        ├── board.txt
        └── message/
            ├── [board_id].txt
            └── [board_id].txt
```

## メモ
- メッセージを取得するとリストに板のメッセージをすべて格納
- 一定時間読み込まれなければリストから削除
- できれば範囲読み取りにも対応（20~40番目まで取得など）