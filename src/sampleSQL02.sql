USE sampleDB02

CREATE TABLE 出荷先 (
    出荷先ID INT IDENTITY(1, 1) CONSTRAINT PK_出荷先ID PRIMARY KEY,
    出荷先名 NVARCHAR(50) NOT NULL,
    出荷先都道府県 NVARCHAR(10) NOT NULL,
    出荷先住所 NVARCHAR(50) NOT NULL
)

CREATE TABLE 受注 (
    受注ID INT IDENTITY(1001, 1) CONSTRAINT PK_受注ID PRIMARY KEY,
    出荷先ID INT NOT NULL CONSTRAINT FK_出荷先ID FOREIGN KEY REFERENCES 出荷先(出荷先ID),
    受注日 DATE NOT NULL
)

CREATE TABLE 商品 (
    商品ID INT IDENTITY(1, 1) CONSTRAINT PK_商品ID PRIMARY KEY,
    商品名 NVARCHAR(30) NOT NULL,
    区分 NVARCHAR(10)
)

CREATE TABLE 受注明細 (
    受注ID INT NOT NULL CONSTRAINT FK_受注ID FOREIGN KEY REFERENCES 受注(受注ID),
    商品ID INT NOT NULL CONSTRAINT FK_商品ID FOREIGN KEY REFERENCES 商品(商品ID),
    単価 MONEY NOT NULL,
    数量 INT NOT NULL
)
   
--データをinsert後

SELECT 受注明細.受注ID, 商品名, 単価, 数量, 単価 * 数量 AS 価格計, 出荷先名 FROM 受注明細 LEFT JOIN 商品
    ON 受注明細.商品ID = 商品.商品ID LEFT JOIN 受注
    ON 受注明細.受注ID = 受注.受注ID LEFT JOIN 出荷先
    ON 受注.出荷先ID = 出荷先.出荷先ID WHERE 受注.受注ID BETWEEN 1001 AND 1005

SELECT SUM(単価 * 数量) AS 受注金額の総合計 FROM 受注明細

SELECT 商品.商品ID, 商品名, 区分, 単価, 単価 * 0.7 AS '3割引' FROM 商品 LEFT JOIN 受注明細
    ON 受注明細.商品ID = 商品.商品ID WHERE 単価 * 0.7 >= 500

SELECT 商品.商品ID, 商品名, SUM(単価 * 数量) AS 受注金額合計 FROM 受注明細
    LEFT JOIN 商品 ON 受注明細.商品ID = 商品.商品ID
    GROUP BY 商品.商品ID, 商品名 ORDER BY SUM(単価 * 数量) DESC

SELECT 出荷先名, COUNT(*) AS 受注回数 FROM 受注
    LEFT JOIN 出荷先 ON 受注.出荷先ID = 出荷先.出荷先ID
    GROUP BY 出荷先名

SELECT DISTINCT 商品名, 商品.商品ID, 区分, 単価 FROM 商品 LEFT JOIN 受注明細
    ON 商品.商品ID = 受注明細.商品ID WHERE 商品名 LIKE (N'%冷凍%')

--単価が4500円以上か総額が25000円以上のデータを抽出、両方該当する場合は二件分のデータとして表示、商品ID昇順
SELECT 商品.商品ID, 商品名, 区分, 単価, SUM(単価 * 数量) AS 総額 FROM 受注明細
    LEFT JOIN 商品 ON 商品.商品ID = 受注明細.商品ID GROUP BY 商品.商品ID, 商品名, 区分, 単価
    HAVING 単価 >= 4500 UNION ALL
        SELECT 商品.商品ID, 商品名, 区分, 単価, SUM(単価 * 数量) AS 総額 FROM 受注明細
        LEFT JOIN 商品 ON 商品.商品ID = 受注明細.商品ID GROUP BY 商品.商品ID, 商品名, 区分, 単価
        HAVING SUM(単価 * 数量) >= 25000

--取引先名と取引先毎の受注合計金額を取得、金額高い順で表示
SELECT 出荷先名, SUM(数量 * 単価) AS 受注合計金額 FROM 受注明細 LEFT JOIN 受注
    ON 受注明細.受注ID = 受注.受注ID LEFT JOIN 出荷先
        ON 受注.出荷先ID = 出荷先.出荷先ID
            GROUP BY 出荷先名 ORDER BY SUM(数量 * 単価) DESC

--2019/06/15 ~ 2019/06/30 までの期間で注文のあった顧客情報を取得、重複なし
SELECT DISTINCT 出荷先名, 出荷先都道府県, 出荷先住所 FROM 受注 LEFT JOIN 出荷先 ON 受注.出荷先ID = 出荷先.出荷先ID
    WHERE 受注日 BETWEEN '2019/06/15' AND '2019/06/30'

--出荷先名と出荷先毎の注文金額計を取得、注文金額が50000円以上のデータを表示
SELECT 出荷先名, SUM(数量 * 単価) AS 注文金額計 FROM 受注明細
    LEFT JOIN 受注 ON 受注.受注ID = 受注明細.受注ID
        LEFT JOIN 出荷先 ON 受注.出荷先ID = 出荷先.出荷先ID
            GROUP BY 出荷先名 HAVING SUM(数量 * 単価) > 50000

--出荷先名と出荷先毎の金額平均を取得、その金額が全体の平均以上かどうかを表示
SELECT 出荷先名,
       AVG(ISNULL(数量, 0) * ISNULL(単価, 0)) AS 金額平均,
        CASE
            WHEN AVG(ISNULL(数量, 0) * ISNULL(単価, 0)) >= (SELECT AVG(ISNULL(数量,0) * ISNULL(単価, 0)) FROM 受注明細)
                THEN N'全体の平均以上'
            ELSE N'全体の平均未満'
        END AS 評価 FROM 受注明細 LEFT JOIN 受注 ON 受注.受注ID = 受注明細.受注ID
            LEFT JOIN 出荷先 ON 出荷先.出荷先ID = 受注.出荷先ID
                GROUP BY 出荷先名